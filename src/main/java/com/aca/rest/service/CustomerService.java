package com.aca.rest.service;

import java.util.List;
import com.aca.rest.dao.CustomerDao;
import com.aca.rest.model.Customer;

/**
 * Business Logic and validation for customers 
 *
 */
public class CustomerService {

	public List<Customer> getAllCustomers(){

		CustomerDao customerDao= new CustomerDao();		
		return customerDao.getAllCustomers();
	}
	
	public int updateCustomer(Customer customer){
		CustomerDao customerDao = new CustomerDao();
		return customerDao.updateCustomer(customer);
	}

	public int insertCustomer(Customer customer) {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.insertCustomer(customer);
	}

	
}
