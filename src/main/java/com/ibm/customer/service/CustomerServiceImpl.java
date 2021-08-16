package com.ibm.customer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.customer.model.Customer;
import com.ibm.customer.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public Customer getCustomer(String customerNumber) {
		logger.info("Entered CustomerServiceImpl.getCustomer().  customerNumber={}", customerNumber);
		
		Customer customer = null;
		
		customer = this.customerRepo.findByCustomerNumber(customerNumber);
		
		logger.info("Leaving CustomerServiceImpl.getCustomer().  Customer={}", customer);
		
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		logger.info("Entered CustomerServiceImpl.getCustomers().");
		
		List<Customer> customers = this.customerRepo.findAll();
		
		logger.info("Leaving CustomerServiceImpl.getCustomers().");
		return customers;
	}

	@Override
	public Customer addCustomer(Customer customerData) {
		logger.info("Entered CustomerServiceImpl.addCustomer().");
		
		Customer customer = this.customerRepo.save(customerData);
		
		logger.info("Leaving CustomerServiceImpl.addCustomer().");
		return customer;
	}

}
