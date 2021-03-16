package com.cg.customermanagement.dto;

public class AddAmountReq {
	private Long customerId;
	private double amount;
	
	public AddAmountReq() {}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
