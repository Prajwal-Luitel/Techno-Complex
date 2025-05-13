package com.technocomplex.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.technocomplex.config.DbConfig;
import com.technocomplex.model.FlatModel;

public class HomeService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor initializes the database connection. Sets the connection error
	 * flag if the connection fails.
	 */
	public HomeService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}  
	
	/**
	 * Retrieves a list of 4 available flats from the database.
	 *
	 *
	 * @return a list of 4 available FlatModel objects, or null if a connection error occurs.
	 */
	public List<FlatModel> getFlatList() {
	    if (isConnectionError) {
	        return null;
	    }

	    List<FlatModel> flatList = new ArrayList<>();
	    String query = "SELECT * FROM flat "
	    		+ "LIMIT 4";

	    try (PreparedStatement selectStmt = dbConn.prepareStatement(query);
	         ResultSet result = selectStmt.executeQuery()) {

	        while (result.next()) {
	            flatList.add(new FlatModel(
		                result.getString("name"),
		                result.getString("category"),
		                result.getInt("price"),
		                result.getInt("size"),
		                result.getInt("living"),
		                result.getInt("bedroom"),
		                result.getInt("kitchen"),
		                result.getString("furnishing"),
		                result.getString("image_Path")
		            ));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return flatList;
	}
	
}
