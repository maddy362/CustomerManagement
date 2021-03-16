package com.cg.customermanagement.dto;

public class GetItemsBoughtReq {
	private String id;
	private double price;
	
	public GetItemsBoughtReq() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
