package com.cg.customermanagement.items.util;

import org.springframework.stereotype.Component;

import com.cg.customermanagement.items.dto.ItemDetails;
import com.cg.customermanagement.items.entities.Items;

@Component
public class ItemsUtil {
public ItemDetails toDetails(Items item) {
		
		ItemDetails details = new ItemDetails();
		details.setId(item.getId());
		details.setPrice(item.getPrice());
		details.setDescription(item.getDescription());
		if(item.getBoughtBy()!=null) {
			details.setCustomerId(item.getBoughtBy().getId());
			details.setCustomerName(item.getBoughtBy().getName());
		}
		return details;
	}

}
