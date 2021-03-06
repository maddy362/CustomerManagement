package com.cg.customermanagement.items.entities;



import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.cg.customermanagement.entities.Customer;



@Entity
public class Items {
   
	@Id
	private String id;
	private double price;
	private String description;
	private LocalDateTime addedDate;
	
	@OneToOne
	private Customer boughtBy;
	
	public Items() {}
	
	public Items(String id, double price, String description, LocalDateTime addedDate) {
		this.id = id;
		this.price = price;
		this.description = description;
		this.addedDate = addedDate;
	}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}
	
	public Customer getBoughtBy() {
		return boughtBy;
	}
	
	public void setBoughtBy(Customer boughtBy) {
		this.boughtBy = boughtBy;
	}
	
	@Override
	public String toString() {
		String text="id:"+id +" price:"+price+" Description:"+description+"Added Date:"+addedDate;
	    return text;
	}
	
	
}