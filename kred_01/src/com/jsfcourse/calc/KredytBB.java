package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
//import javax.enterprise.context.SessionScoped;
//import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {
	private Double amount;
	private Integer months;
	private Double intrestRate;
	private Double result;

	@Inject
	FacesContext ctx;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	
	public Double getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(Double intrestRate) {
		this.intrestRate = intrestRate;
	}
	
	public boolean doTheMath() {
		try {
			
			
			intrestRate=intrestRate/100;
			result = (amount+(amount*intrestRate))/months;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³¹d podczas przetwarzania parametrów", null));
			return false;
		}
	}
 
	public String calc() {
		
		if (doTheMath()) {
			return "showresult";
		}
		return null;
		
		
	}


	

	
}
