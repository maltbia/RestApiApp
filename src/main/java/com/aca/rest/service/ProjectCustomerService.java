package com.aca.rest.service;

import java.util.List;
import com.aca.rest.dao.ProjectCustomerDao;
import com.aca.rest.model.ProjectCustomer;


/**
 * Business Logic and validation for customers 
 *
 */
public class ProjectCustomerService {

	public List<ProjectCustomer> getAllCustomers(){

		ProjectCustomerDao projectCustomerDao= new ProjectCustomerDao();		
		return projectCustomerDao.getAllCustomers();
	}
	
	public int updateCustomer(ProjectCustomer customer){
		ProjectCustomerDao projectCustomerDao = new ProjectCustomerDao();
		return projectCustomerDao.updateCustomer(customer);
	}

	public int insertCustomer(ProjectCustomer customer) {
		ProjectCustomerDao projectCustomerDao = new ProjectCustomerDao();
		int key = projectCustomerDao.insertCustomer(customer);
		
		
		
		System.out.println("key: " + key);
		System.out.println("email: " + customer.getEmail());
		
		String arn = null;
		
		if(customer.getEmail() != null){			
			
			arn = new AwsService().subscribe(customer.getEmail());
			
			System.out.println("arn: " + arn);
			
			// TODO I need to insert Arn, email, customerid into aws_emailoptin on the DOA
			int rowsInserted = projectCustomerDao.insertArn(customer, arn, key);
			System.out.println("rows inserted into aws_emailoptin: " + rowsInserted);
		}
		
		
		
		return key;
	}
	
	
}
