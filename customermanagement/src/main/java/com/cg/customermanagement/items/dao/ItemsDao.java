package com.cg.customermanagement.items.dao;

import com.cg.customermanagement.items.entities.Items;

public interface ItemsDao {
	Items add(Items item);
	Items update(Items item);
	Items findById(String itemId);
}
