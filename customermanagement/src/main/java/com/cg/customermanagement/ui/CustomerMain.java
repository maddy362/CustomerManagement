package com.cg.customermanagement.ui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customermanagement.entities.Customer;
import com.cg.customermanagement.service.ICustomerService;



@Component
public class CustomerMain {

	@Autowired
	private ICustomerService service;


	public void start() {

		Customer customer1=service.createCustomer("Madhusudan Sharma");
		System.out.println(customer1);
		Customer customer2=service.createCustomer("Bhavna Sharma");
		System.out.println(customer2);

		Customer findCustomer1=service.findByID(2);
		System.out.println("Customer found with id "+ findCustomer1.getId()+ "And name= "+findCustomer1.getName());
		Customer findCustomer2=service.findByID(4);
		System.out.println("Customer found "+ findCustomer2.getId()+ "And name= "+findCustomer2.getName());



	}

}

