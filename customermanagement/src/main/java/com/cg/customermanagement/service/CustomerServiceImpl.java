package com.cg.customermanagement.service;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customermanagement.dao.ICustomerDao;
import com.cg.customermanagement.entities.Account;
import com.cg.customermanagement.entities.Customer;
import com.cg.customermanagement.items.entities.Items;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;

	@Autowired
	private EntityManager entityManager;

	@Override
	public Customer findByID(long customerID) {
		Customer customer = dao.findByID(customerID);
		return customer;
	}

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		LocalDateTime currentTime = LocalDateTime.now();
		Account account = new Account(-1, currentTime);
		entityManager.persist(account);
		Customer customer = new Customer(name, account);
		return dao.add(customer);
	}

	@Override
	public Set<Items> itemsBoughtByCustomer(Long customerId) {
		Customer customer  = dao.findByID(customerId);
		Set<Items> boughtItems = customer.getBoughtItems();
		return boughtItems;
	}
    @Transactional
	@Override
	public Customer addAmount(Long customerId, double amount) {
		Customer customer = dao.findByID(customerId);
		customer.getAccount().setBalance(amount);
		dao.update(customer);
		return customer;
	}

}
