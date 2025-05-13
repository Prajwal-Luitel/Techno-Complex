package com.technocomplex.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.technocomplex.config.DbConfig;

public class ProfilePicService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor initializes the database connection. Sets the connection error
	 * flag if the connection fails.
	 */
	public ProfilePicService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}
	
	/**
	 * Retrieves the profile pic url  of a user based on their username from the database.
	 *
	 * @param userName Username whose profile url is to be retrieve. 
	 * @return The url of the user profile as a String if found; null if not found or an error occurs.
	 */
	public String getUserProfile(String userName) {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}
		
		String query = "SELECT profile_path FROM user WHERE username = ?";
		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			stmt.setString(1, userName);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				return result.getString("profile_path");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
