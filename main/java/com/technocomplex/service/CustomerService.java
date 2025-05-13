package com.technocomplex.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.technocomplex.config.DbConfig;
import com.technocomplex.model.UserModel;

public class CustomerService {
	
	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor initializes the database connection. Sets the connection error
	 * flag if the connection fails.
	 */
	public CustomerService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}  
 
	/**
	 * Retrieves a list of all available flats from the database.
	 *
	 * This method checks if there is a connection error before executing the query.
	 * Only flats with a status of 'available' are included in the result.
	 *
	 * @return a list of available FlatModel objects, or null if a connection error occurs.
	 */
	public List<UserModel> getUserList() {
	    if (isConnectionError) {
	        return null;
	    }

	    List<UserModel> userList = new ArrayList<>();
	    String query = "SELECT * FROM user";

	    try (PreparedStatement selectStmt = dbConn.prepareStatement(query);
	         ResultSet result = selectStmt.executeQuery()) {

	        while (result.next()) {
	            userList.add(new UserModel(
		                result.getInt("user_id"),
		                result.getString("name"),
		                result.getString("phone"),
		                result.getString("email"),
		                result.getDate("dob").toLocalDate(), 
		                result.getString("gender"),
		                result.getString("username"),
		                result.getString("profile_path")
		            ));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userList;
	}
}
