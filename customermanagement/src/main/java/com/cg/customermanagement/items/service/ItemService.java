package com.cg.customermanagement.items.service;

import com.cg.customermanagement.items.entities.Items;

public interface ItemService {
	Items create(double price, String description);
	Items findById(String itemId);
	Items buyItem(String itemId, Long customerId);
}
