package com.technocomplex.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.technocomplex.config.DbConfig;
import com.technocomplex.model.UserModel;

/**
 * RegisterService handles the registration of new customer. It manages database
 * interactions for customer registration.
 */
public class RegisterService {

	private Connection dbConn;

	/**
	 * Constructor initializes the database connection.
	 */
	public RegisterService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * Registers a new user in the database.
	 *
	 * @param userModel the user details to be registered
	 * @return Boolean indicating the success of the operation
	 */
	public Boolean addUser(UserModel userModel) {
		if (dbConn == null) {
			System.err.println("Database connection is not available.");
			return null;
		}

		String insertQuery = "INSERT INTO user (name, phone, email, dob, gender, username, password, role, profile_path) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)"; // 9

		try (PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {

			// Insert user details
			insertStmt.setString(1, userModel.getName());
			insertStmt.setString(2, userModel.getPhone());
			insertStmt.setString(3, userModel.getEmail());
			insertStmt.setDate(4, Date.valueOf(userModel.getDob()));
			insertStmt.setString(5, userModel.getGender());
			insertStmt.setString(6, userModel.getUserName());
			insertStmt.setString(7, userModel.getPassword());
			insertStmt.setString(8, "customer"); // setting the role to customer
			insertStmt.setString(9, userModel.getProfileImageUrl());

			return insertStmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error during student registration: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Checks if a username already exists in the database.
	 *
	 * @param username the username to check
	 * @return true if taken, false otherwise
	 */
	public boolean isUsernameTaken(String username) {
		if (dbConn == null) {
			return false;
		}

		String query = "SELECT 1 FROM user WHERE username = ?";
		try (PreparedStatement selectStmt = dbConn.prepareStatement(query)) {
			selectStmt.setString(1, username);
			ResultSet result = selectStmt.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Checks if an phone already exists in the database.
	 *
	 * @param phone the phone to check
	 * @return true if taken, false otherwise
	 */
	public boolean isPhoneTaken(String phone) {
		if (dbConn == null) {
			return false;
		}
		String query = "SELECT 1 FROM user WHERE phone = ?";
		try (PreparedStatement selectStmt = dbConn.prepareStatement(query)) {
			selectStmt.setString(1, phone);
			ResultSet result = selectStmt.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Checks if an email already exists in the database.
	 *
	 * @param email the email to check
	 * @return true if taken, false otherwise
	 */
	public boolean isEmailTaken(String email) {
		if (dbConn == null) {
			return false;
		}
		String query = "SELECT 1 FROM user WHERE email = ?";
		try (PreparedStatement selectStmt = dbConn.prepareStatement(query)) {
			selectStmt.setString(1, email);
			ResultSet result = selectStmt.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
}