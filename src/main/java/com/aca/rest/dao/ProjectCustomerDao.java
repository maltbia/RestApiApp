package com.aca.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.aca.rest.model.ProjectCustomer;


/**
 * It encapsulate all the information to make a call to the database to retrieve information
 * DAO(Data Access Object)- encapsulate our logic to retrieve customers from the Maria DB.
 */
public class ProjectCustomerDao {

	private final static String SQL_SELECT_ALL_CUSTOMERS = " SELECT CustomerID, FirstName, LastName, Phone, Street,  City, "
															+  " State, Zip, Email, Services, Monday, Tuesday, Wednesday, Thursday, " 
															+ " Friday, Saturday, Sunday " +
														   " FROM customer_request";
	private final static String SQL_UPDATE_CUSTOMER_BY_ID = " UPDATE customer_request" +
															" SET FirstName = ? , LastName = ? , Phone = ?, Monday = ?, Tuesday = ?, "
															+ " Wednesday = ?, Thursday = ?, Friday = ?, Saturday = ?, Sunday = ? " +
															" WHERE CustomerID = ? ";
	private final static String SQL_INSERT_CUSTOMER = " INSERT INTO customer_request " +
													  " ( FirstName, LastName, Phone, Street, City, State, Zip, Email, "
													  + " Services, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday ) " +
													  " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	private final static String SQL_CUSTOMER_KEY = "SELECT @@Identity AS CustomerId ";
	private final static String SQL_INSERT_ARN = " INSERT INTO aws_emailoptin " +
			  									 " (customerId, email, arn ) " +
			  									 " VALUES (?,?,?) ";
	
	

	public List<ProjectCustomer> getAllCustomers(){

		List<ProjectCustomer> customers = new ArrayList<ProjectCustomer>();
 
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
				ProjectCustomer customer = new ProjectCustomer();
				customer.setCustomerId(result.getString("CustomerID"));
				customer.setFirstName(result.getString("FirstName"));
				customer.setLastName(result.getString("LastName"));
				customer.setPhone(result.getString("Phone"));
				customer.setStreet(result.getString("Street"));
				customer.setCity(result.getString("City"));
				customer.setState(result.getString("State"));
				customer.setZip(result.getString("Zip"));
				customer.setEmail(result.getString("Email"));
				customer.setServices(result.getString("Services"));
				customer.setMonday(result.getBoolean("Monday"));
				customer.setTuesday(result.getBoolean("Tuesday"));
				customer.setWednesday(result.getBoolean("Wednesday"));
				customer.setThursday(result.getBoolean("Thursday"));
				customer.setFriday(result.getBoolean("Friday"));
				customer.setSaturday(result.getBoolean("Saturday"));
				customer.setSunday(result.getBoolean("Sunday"));
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

	public int updateCustomer(ProjectCustomer customer){

		int rowsUpdated = 0;
		int customerKey = 0;
		PreparedStatement statement = null;

		Connection conn = MariaDbUtil.getConnection();

		try{

			/**
			 * General-purpose access to your database.
			 * Useful when you are using static SAL statements at runtime.
			 * The Statement interface cannot accept parameters.
			 */

			statement = conn.prepareStatement(SQL_UPDATE_CUSTOMER_BY_ID);
			statement.setString(1, customer.getCustomerId());
			statement.setString(2, customer.getFirstName());
			statement.setString(3, customer.getLastName());
			statement.setString(4, customer.getPhone());
			statement.setString(5, customer.getStreet());
			statement.setString(6, customer.getCity());
			statement.setString(7, customer.getState());
			statement.setString(8, customer.getZip());
			statement.setString(9, customer.getEmail());
			statement.setString(10, customer.getServices());
			statement.setBoolean(11, customer.getMonday());
			statement.setBoolean(12, customer.getTuesday());
			statement.setBoolean(13, customer.getWednesday());
			statement.setBoolean(14, customer.getThursday());
			statement.setBoolean(15, customer.getFriday());
			statement.setBoolean(16, customer.getSaturday());
			statement.setBoolean(17, customer.getSunday());	
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
		return customerKey;
	}
	
	//return the number of rows updated
	public int insertCustomer(ProjectCustomer customer){

		int rowsInserted = 0;
		int customerKey = 0;
		PreparedStatement statement = null;

		Connection conn = MariaDbUtil.getConnection();

		try{

			/**
			 * General-purpose access to your database.
			 * Useful when you are using static SAL statements at runtime.
			 * The Statement interface cannot accept parameters.
			 */

			statement = conn.prepareStatement(SQL_INSERT_CUSTOMER);
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getPhone());
			statement.setBoolean(4, customer.getMonday());
			statement.setBoolean(5, customer.getTuesday());
			statement.setBoolean(6, customer.getWednesday());
			statement.setBoolean(7, customer.getThursday());
			statement.setBoolean(8, customer.getFriday());
			statement.setBoolean(9, customer.getSaturday());
			statement.setBoolean(10, customer.getSunday());
			

			/**
			 * Returns a ResultSet object.
			 * Use this method when you expect to get a result set,
			 * as you would with a SELECT statement.
			 */

			rowsInserted = statement.executeUpdate();
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(SQL_CUSTOMER_KEY);
			
			while(res.next()) {
				
				customerKey = res.getInt("CustomerId");
			}
			
			

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
		return customerKey;
	}
	
	public int customerKey() {

		int customerKey = 0;
		Statement statement = null;
		ResultSet result = null;
		
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

			result = statement.executeQuery(SQL_CUSTOMER_KEY);
			
			while(result.next()){
				customerKey = result.getInt("CustomerId");
				
				
		
			}
			
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
		return customerKey;
	}
	
	public int insertArn(ProjectCustomer customer, String arn, int key){

		int rowsInserted = 0;
		PreparedStatement statement = null;

		Connection conn = MariaDbUtil.getConnection();

		try{

			/**
			 * General-purpose access to your database.
			 * Useful when you are using static SAL statements at runtime.
			 * The Statement interface cannot accept parameters.
			 */

			statement = conn.prepareStatement(SQL_INSERT_ARN );
			statement.setInt(1, key);
			statement.setString(2, customer.getEmail());
			statement.setString(3, arn);
			

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
