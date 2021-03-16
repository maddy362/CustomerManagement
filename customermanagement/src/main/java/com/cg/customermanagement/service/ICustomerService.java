package com.cg.customermanagement.service;

import java.util.Set;

import com.cg.customermanagement.entities.Customer;
import com.cg.customermanagement.items.entities.Items;

public interface ICustomerService {
	public Customer findByID(long customerID);
    public Customer createCustomer(String name);
    Set<Items> itemsBoughtByCustomer(Long customerId);
    Customer addAmount(Long customerId, double amount);
}
