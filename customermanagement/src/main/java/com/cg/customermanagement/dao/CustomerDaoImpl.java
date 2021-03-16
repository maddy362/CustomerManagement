package com.cg.customermanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.customermanagement.entities.Account;
import com.cg.customermanagement.entities.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Customer add(Customer customer){
		
		Account account = customer.getAccount();
		entityManager.persist(account);
		entityManager.persist(customer);
		return customer;
	}
	
	
	@Override
    public Customer findByID(Long customerID) {
    	
    	Customer customer=entityManager.find(Customer.class, customerID);
    	return customer;
    }
	
	@Override
    public Customer update(Customer customer) {
    	
		Account account = customer.getAccount();
		account=entityManager.merge(account);
		customer=entityManager.merge(customer);
		return customer;
    }
}