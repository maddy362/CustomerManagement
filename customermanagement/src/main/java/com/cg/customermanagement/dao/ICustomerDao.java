package com.cg.customermanagement.dao;

import com.cg.customermanagement.entities.Customer;

public interface ICustomerDao {
	public Customer add (Customer customer);
	public Customer findByID(Long customerID);
	public Customer update(Customer customer);

}
