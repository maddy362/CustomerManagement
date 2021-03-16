package com.cg.customermanagement.items.ui;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customermanagement.entities.Customer;
import com.cg.customermanagement.items.entities.Items;
import com.cg.customermanagement.items.service.ItemService;
import com.cg.customermanagement.service.ICustomerService;
@Component
public class ItemsUI {
	@Autowired
	ItemService itemservice;
	
	@Autowired
	ICustomerService customerservice;
	
	public void start() {
		
		Customer customer1 = customerservice.createCustomer("Maddy");
		Customer customer2 = customerservice.createCustomer("Gigi");
		Customer customer3 = customerservice.createCustomer("Gogo");
		
		customerservice.addAmount(customer1.getId(), 40500);
		customerservice.addAmount(customer2.getId(), 12200);
		customerservice.addAmount(customer3.getId(), 55000);
		
		Items item1 = itemservice.create(5200, "Xiaomi 4");
		Items item2 = itemservice.create(22000, "One Plus 8");
		Items item3 = itemservice.create(55000, "Iphone 5s");
		Items item4 = itemservice.create(40000, "Samsung Fold");
		
		itemservice.buyItem(item1.getId(), customer1.getId());
		itemservice.buyItem(item2.getId(), customer2.getId());
		itemservice.buyItem(item3.getId(), customer3.getId());
		itemservice.buyItem(item4.getId(), customer1.getId());
		
		Customer fetchedCustomer1 = customerservice.findByID(customer1.getId());
		Customer fetchedCustomer2 = customerservice.findByID(customer2.getId());
		Customer fetchedCustomer3 = customerservice.findByID(customer3.getId());
		
		Items fetchedItem1 = itemservice.findById(item1.getId());
		Items fetchedItem2 = itemservice.findById(item2.getId());
		Items fetchedItem3 = itemservice.findById(item3.getId());
		Items fetchedItem4 = itemservice.findById(item4.getId());
		
		System.out.println("\n---------Displaying output for fetched customer--------\n");
		display(fetchedCustomer1);
		display(fetchedCustomer2);
		display(fetchedCustomer3);
		
		System.out.println("\n-------Item Details-------\n");
		
		display(fetchedItem1);
		display(fetchedItem2);
		display(fetchedItem3);
		display(fetchedItem4);
		
	}
	
	public void display(Customer customer) {
		System.out.println("\nCustomerID: "+customer.getId()
							+"\nCustomer Name: "+customer.getName()
							+"\nCustomer AccountId: "+customer.getAccount().getAccountId()
							+"\nCustomer Balance: "+customer.getAccount().getBalance()
							+"\nAccount created on: "+customer.getAccount().getCreated()
							+"\nItems Bought:");
		Set<Items> itemList = customerservice.itemsBoughtByCustomer(customer.getId());
		for(Items item:itemList) {
			System.out.println("Item id = "+item.getId()+" | Item desc. = "+item.getDescription()+" | Item price = "+item.getPrice());
		}
		
	}
	

	public void display(Items item) {
		
		System.out.println("ItemID: "+item.getId()
							+"\nItem Price: "+item.getPrice()
							+"\nItem description: "+item.getDescription()
							+"\nItem added on: "+item.getAddedDate()
							+"\nItem bought by: "+item.getBoughtBy().getName()
							+"\n");
	}
}



