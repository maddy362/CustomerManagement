package com.cg.customermanagement.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customermanagement.dto.AddAmountReq;
import com.cg.customermanagement.dto.CustomerDetails;
import com.cg.customermanagement.dto.GetItemsBoughtReq;
import com.cg.customermanagement.entities.Customer;
import com.cg.customermanagement.service.ICustomerService;
import com.cg.customermanagement.util.CustomerUtil;

@RequestMapping("/customers")
@RestController
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerUtil util;
	
	@GetMapping(value = "/byid/{id}")
	public CustomerDetails fetchCustomer(@PathVariable("id") Long customerId){
		
		Customer customer = service.findByID(customerId);
		CustomerDetails details = util.customerDetailsById(customer);
		return details;
				
	}
	
	@PutMapping("/addamount")
	public CustomerDetails addAmount(@RequestBody AddAmountReq requestData) {
	
		Customer customer = service.addAmount(requestData.getCustomerId(), requestData.getAmount());
		CustomerDetails details = util.customerDetailsById(customer);
		return details;
		
	}
	
	@GetMapping(value = "/getitemsbought/{id}")
	public List<GetItemsBoughtReq> getitemsBought(@PathVariable("id") Long customerId){
		
		Customer customer = service.findByID(customerId);
		List<GetItemsBoughtReq> itemList = util.getItemList(customer.getBoughtItems());
		return itemList;
	}
}