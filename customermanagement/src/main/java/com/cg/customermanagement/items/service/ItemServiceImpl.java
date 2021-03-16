package com.cg.customermanagement.items.service;



import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.customermanagement.dao.ICustomerDao;
import com.cg.customermanagement.entities.Customer;
import com.cg.customermanagement.items.dao.ItemsDao;
import com.cg.customermanagement.items.entities.Items;
@Repository
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemsDao itemDao;
	
	@Autowired
	ICustomerDao customerDao;
	
	@Transactional
	@Override
	public Items create(double price, String description) {
		Items item=new Items(createId(), price, description, LocalDateTime.now());
		itemDao.add(item);
		return item;
	}
	
	@Override
	public Items findById(String itemId) {
		Items item=itemDao.findById(itemId);
		return item;
	}
	
	@Transactional
	@Override
	public Items buyItem(String itemId, Long customerId) {
		Customer customer = customerDao.findByID(customerId);
		Items item = itemDao.findById(itemId);
		item.setBoughtBy(customer);
		itemDao.update(item);
		Set<Items> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		customerDao.update(customer);
		return item;
	}
	
	public String createId() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 10;
		for(int i=0;i<length;i++) {
			int index=random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String id=sb.toString();
		return id;
	}
	
}

