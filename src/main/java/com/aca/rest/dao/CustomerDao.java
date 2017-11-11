package com.aca.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.aca.rest.model.Customer;


/**
 * It encapsulate all the information to make a call to the database to retrieve information
 * DAO(Data Access Object)- encapsulate our logic to retrieve customers from the Maria DB.
 */
public class CustomerDao {

	private final static String SQL_SELECT_ALL_CUSTOMERS = " SELECT CustomerID, CompanyName, City, Country " +
														   " FROM customer";
	private final static String SQL_UPDATE_CUSTOMER_BY_ID = " UPDATE customer" +
															" SET companyName = ? , city = ? , country = ? " +
															" WHERE CustomerID = ? ";
	private final static String SQL_INSERT_CUSTOMER = " INSERT INTO customer " +
													  " (customerId, companyName, city, country) " +
													  " VALUES (?,?,?,?) ";
	
	public List<Customer> getAllCustomers(){

		List<Customer> customers = new ArrayList<Customer>();
 
		ResultSet result = null;
		Statement statement = null;

		Connection conn = MariaDbUtil.getConnection();

		try{

			/**
			 * General-purpose access to your database.
			 * Useful when you are using static SAL statements at runtime.
			 * The Statement interface cannot accept parameters.
			 */

			statement = conn.createStatement();

			/**
			 * Returns a ResultSet object.
			 * Use this method when you expect to get a result set,
			 * as you would with a SELECT statement.
			 */

			result = statement.executeQuery(SQL_SELECT_ALL_CUSTOMERS);

			while(result.next()){
				Customer customer = new Customer();
				customer.setCustomerId(result.getString("CustomerID"));
				customer.setCompanyName(result.getString("CompanyName"));
				customer.setCity(result.getString("City"));
				customer.setCountry(result.getString("Country"));
				customers.add(customer);
			}

		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				result.close();
				statement.close();
				conn.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return customers;
	}
	
//	public List<Customer> getById(String customerId){
//
//		List<Customer> customers = new ArrayList<Customer>();
//
//		ResultSet result = null;
//		PreparedStatement statement = null;
//
//		Connection conn = MariaDbUtil.getConnection();
//
//		try{
//			
//			/**
//			 * General-purpose access to your database.
//			 * Useful when you are using static SAL statements at runtime.
//			 * The PreparedStatement interface can accept parameters.
//			 */
//
//			statement = conn.prepareStatement(SQL_SELECT_ALL_CUSTOMERS);
//			statement.setString(1, customerId);
//			
//			
//			/**
//			 * Returns a ResultSet object.
//			 * Use this method when you expect to get a result set,
//			 * as you would with a SELECT statement.
//			 */
//
//			result = statement.executeQuery();
//
//			while(result.next()){
//				Customer customer = new Customer();
//				customer.setCustomerId(result.getString("CustomerID"));
//				customer.setCompanyName(result.getString("CompanyName"));
//				customer.setCity(result.getString("City"));
//				customer.setCountry(result.getString("Country"));
//				customers.add(customer);
//
//						
//		} catch (SQLException e){
//			e.printStackTrace();
//		}finally{
//			try{
//				/**
//				 * Close a Connection object to save database resources,
//				 * for the same reason you should also close the Statement object.
//				 * A simple call to the close () method will do the job.
//				 * 
//				 * 
//				 */
//				result.close();
//				statement.close();
//				conn.close();
//			}catch (SQLException e){
//				e.printStackTrace();
//			}
//		}
//		return id;
//	}
	
	//return the number of rows updated
	public int updateCustomer(Customer customer){

		int rowsUpdated = 0;
		PreparedStatement statement = null;

		Connection conn = MariaDbUtil.getConnection();

		try{

			/**
			 * General-purpose access to your database.
			 * Useful when you are using static SAL statements at runtime.
			 * The Statement interface cannot accept parameters.
			 */

			statement = conn.prepareStatement(SQL_UPDATE_CUSTOMER_BY_ID);
			statement.setString(1, customer.getCompanyName());
			statement.setString(2, customer.getCity());
			statement.setString(3, customer.getCountry());
			statement.setString(4, customer.getCustomerId());

			/**
			 * Returns a ResultSet object.
			 * Use this method when you expect to get a result set,
			 * as you would with a SELECT statement.
			 */

			rowsUpdated = statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				statement.close();
				conn.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return rowsUpdated;
	}
	
	//return the number of rows updated
	public int insertCustomer(Customer customer){

		int rowsInserted = 0;
		PreparedStatement statement = null;

		Connection conn = MariaDbUtil.getConnection();

		try{

			/**
			 * General-purpose access to your database.
			 * Useful when you are using static SAL statements at runtime.
			 * The Statement interface cannot accept parameters.
			 */

			statement = conn.prepareStatement(SQL_INSERT_CUSTOMER);
			statement.setString(1, customer.getCustomerId());
			statement.setString(2, customer.getCompanyName());
			statement.setString(3, customer.getCity());
			statement.setString(4, customer.getCountry());
			

			/**
			 * Returns a ResultSet object.
			 * Use this method when you expect to get a result set,
			 * as you would with a SELECT statement.
			 */

			rowsInserted = statement.executeUpdate();

		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				statement.close();
				conn.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return rowsInserted;
	}
	
	
}
