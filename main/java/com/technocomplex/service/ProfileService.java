package com.technocomplex.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.technocomplex.config.DbConfig;
import com.technocomplex.model.UserModel;

public class ProfileService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	public ProfileService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	/**
	 * Retrieves full user information from the database based on the provided
	 * username.
	 *
	 * @param username The username of the user to retrieve
	 * @return A UserModel object containing the user's details, or null if not
	 *         found or on connection error
	 */
	public UserModel getUserInformation(String username) {
		if (isConnectionError) {
			return null;
		}

		String query = "SELECT * FROM user WHERE username = ?";
		try (PreparedStatement selectStmt = dbConn.prepareStatement(query)) {
			selectStmt.setString(1, username);
			ResultSet result = selectStmt.executeQuery();

			if (result.next()) {
				return new UserModel(result.getInt("user_id"), result.getString("name"), result.getString("phone"),
						result.getString("email"), result.getDate("dob").toLocalDate(), result.getString("gender"),
						result.getString("username"), result.getString("password"), result.getString("role"),
						result.getString("profile_path"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retrieves the user ID from the database using the provided username.
	 *
	 * @param username The username whose user ID is to be fetched
	 * @return The user ID if found, or null if not found or on connection error
	 */
	public Integer getUserId(String username) {
		if (isConnectionError) {
			return null;
		}

		String query = "SELECT user_id FROM user WHERE username = ?";
		try (PreparedStatement selectStmt = dbConn.prepareStatement(query)) {
			selectStmt.setString(1, username);
			ResultSet result = selectStmt.executeQuery();

			if (result.next()) {
				return result.getInt("user_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Updates an existing user's information in the database. The user is
	 * identified by the user ID contained in the UserModel object.
	 *
	 * @param userModel     the user details to be updated
	 * @param currentUserId The ID of the current user to exclude from the check
	 * @return Boolean indicating the success of the operation
	 */
	public Boolean updateUser(UserModel userModel) {
		if (isConnectionError) {
			System.err.println("Database connection is not available.");
			return null;
		}

		String updateSQL‎ = "Update  user SET name = ?, phone = ?, email = ?, dob = ?, gender = ?, username = ?, password = ?, profile_path = ? WHERE user_id = ?";

		try (PreparedStatement preparedStatement = dbConn.prepareStatement(updateSQL‎)) {

			// Insert user details
			preparedStatement.setString(1, userModel.getName());
			preparedStatement.setString(2, userModel.getPhone());
			preparedStatement.setString(3, userModel.getEmail());
			preparedStatement.setDate(4, Date.valueOf(userModel.getDob()));
			preparedStatement.setString(5, userModel.getGender());
			preparedStatement.setString(6, userModel.getUserName());
			preparedStatement.setString(7, userModel.getPassword());
			preparedStatement.setString(8, userModel.getProfileImageUrl());
			preparedStatement.setInt(9, userModel.getUserId());

			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error during student registration: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Checks if a username already exists in the database.
	 *
	 * @param username      the username to check
	 * @param currentUserId The ID of the current user to exclude from the check
	 * @return true if taken, false otherwise
	 */
	public boolean isUsernameTaken(String username, int currentUserId) {
		if (dbConn == null) {
			return false;
		}

		String query = "SELECT 1 FROM user WHERE username = ? AND user_id != ?";
		try (PreparedStatement selectStmt = dbConn.prepareStatement(query)) {
			selectStmt.setString(1, username);
			selectStmt.setInt(2, currentUserId);
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
	 * @param phone         the phone to check
	 * @param currentUserId The ID of the current user to exclude from the check
	 * @return true if taken, false otherwise
	 */
	public boolean isPhoneTaken(String phone, int currentUserId) {
		if (dbConn == null) {
			return false;
		}
		String query = "SELECT 1 FROM user WHERE phone = ? AND user_id != ?";
		try (PreparedStatement selectStmt = dbConn.prepareStatement(query)) {
			selectStmt.setString(1, phone);
			selectStmt.setInt(2, currentUserId);
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
	 * @param email         the email to check
	 * @param currentUserId The ID of the current user to exclude from the check
	 * @return true if taken, false otherwise
	 */
	public boolean isEmailTaken(String email, int currentUserId) {
		if (dbConn == null) {
			return false;
		}
		String query = "SELECT 1 FROM user WHERE email = ? AND user_id != ?";
		try (PreparedStatement selectStmt = dbConn.prepareStatement(query)) {
			selectStmt.setString(1, email);
			selectStmt.setInt(2, currentUserId);
			ResultSet result = selectStmt.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
