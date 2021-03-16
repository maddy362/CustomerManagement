package com.cg.customermanagement.items.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.customermanagement.items.entities.Items;

@Repository
public class ItemDaoImpl implements ItemsDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Items add(Items item) {
		
		entityManager.persist(item);
		return item;
	}
	
	@Override 
	public Items update(Items item) {
		
		item = entityManager.merge(item);
		return item;
	}
	
	@Override
	public Items findById(String itemId) {
		
		Items item = entityManager.find(Items.class, itemId);
		return item;
	}
}