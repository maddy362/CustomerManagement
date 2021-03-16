package com.cg.customermanagement.items.dto;

public class BuyItemReq {
	private String itemId;
	private Long customerId;
	
	public BuyItemReq() {}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
}
