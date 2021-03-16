package com.cg.customermanagement.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.customermanagement.dto.CustomerDetails;
import com.cg.customermanagement.dto.GetItemsBoughtReq;
import com.cg.customermanagement.entities.Customer;
import com.cg.customermanagement.items.entities.Items;

@Component
public class CustomerUtil {
	
	public CustomerDetails customerDetailsById(Customer customer) {
		CustomerDetails details = new CustomerDetails();
		details.setId(customer.getId());
		details.setName(customer.getName());
		details.setAccountId(customer.getAccount().getAccountId());
		details.setBalance(customer.getAccount().getBalance());
		return details;
	}
	
	public List<GetItemsBoughtReq> getItemList(Set<Items> itemSet){
		List<GetItemsBoughtReq> itemList = new ArrayList<>();
		for(Items item : itemSet) {
			GetItemsBoughtReq itemsBought = new GetItemsBoughtReq();
			itemsBought.setId(item.getId());
			itemsBought.setPrice(item.getPrice());
			itemList.add(itemsBought);
		}
		return itemList;
	}
}
