package com.cg.customermanagement.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customermanagement.items.dto.BuyItemReq;
import com.cg.customermanagement.items.dto.ItemDetails;
import com.cg.customermanagement.items.entities.Items;
import com.cg.customermanagement.items.service.ItemService;
import com.cg.customermanagement.items.util.ItemsUtil;

@RequestMapping("/items")
@RestController
public class ItemsController {

	@Autowired
	ItemService service;
	
	@Autowired
	ItemsUtil util;
	
	@GetMapping(value = "/itembyid/{id}")
	public ItemDetails fetchitems(@PathVariable("id") String itemId) {
		ItemDetails details = util.toDetails(service.findById(itemId));
		return details;
	}
	
	@PutMapping("/buyitem")
	public ItemDetails buyitems(@RequestBody BuyItemReq requestData) {
		Items item = service.buyItem(requestData.getItemId(), requestData.getCustomerId());
		ItemDetails details = util.toDetails(item);
		return details;
	}
}
