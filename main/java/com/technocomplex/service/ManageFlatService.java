package com.technocomplex.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.technocomplex.config.DbConfig;
import com.technocomplex.model.FlatModel;

public class ManageFlatService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor initializes the database connection. Sets the connection error
	 * flag if the connection fails.
	 */
	public ManageFlatService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	/**
	 * Retrieves a list of all flats from the database.
	 *
	 * This method checks if there is a connection error before executing the query.
	 *
	 * @return a list of available FlatModel objects, or null if a connection error
	 *         occurs.
	 */
	public List<FlatModel> getFlatList() {
		if (isConnectionError) {
			return null;
		}

		List<FlatModel> flatList = new ArrayList<>();
		String query = "SELECT * FROM flat;";

		try (PreparedStatement selectStmt = dbConn.prepareStatement(query);
				ResultSet result = selectStmt.executeQuery()) {

			while (result.next()) {
				flatList.add(new FlatModel(result.getInt("flat_id"), result.getString("name"),
						result.getString("category"), result.getInt("price"), result.getInt("size"),
						result.getInt("living"), result.getInt("bedroom"), result.getInt("kitchen"),
						result.getString("furnishing"), result.getString("image_Path"), result.getString("status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flatList;
	}

	/**
	 * Registers a new flat in the database.
	 *
	 * @param flatModel the flat details to be added
	 * @return Boolean indicating the success of the operation
	 */
	public Boolean addFlat(FlatModel flatModel) {
		if (dbConn == null) {
			System.err.println("Database connection is not available.");
			return null;
		}

		String insertQuery = "INSERT INTO flat (name, category, price, size, living, bedroom, kitchen, furnishing, image_path, status) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // 10

		try (PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {
			// Insert user details
			insertStmt.setString(1, flatModel.getName());
			insertStmt.setString(2, flatModel.getCategory());
			insertStmt.setInt(3, flatModel.getPrice());
			insertStmt.setInt(4, flatModel.getSize());
			insertStmt.setInt(5, flatModel.getLivingroom());
			insertStmt.setInt(6, flatModel.getBedroom());
			insertStmt.setInt(7, flatModel.getKitchen());
			insertStmt.setString(8, flatModel.getFurnishing());
			insertStmt.setString(9, flatModel.getImage_Path());
			insertStmt.setString(10, flatModel.getStatus());

			return insertStmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error during flat data registration: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Updates an existing flat in the database based on its flat ID.
	 *
	 * @param flatModel the flat details to be updated
	 * @return Boolean indicating the success of the operation
	 */
	public Boolean updateFlat(FlatModel flatModel) {
		if (dbConn == null) {
			System.err.println("Database connection is not available.");
			return null;
		}

		String updateQuery = "UPDATE flat SET name = ?, category = ?, price = ?, size = ?, living = ?, "
				+ "bedroom = ?, kitchen = ?, furnishing = ?, image_path = ?, status = ? WHERE flat_id = ?";

		try (PreparedStatement updateStmt = dbConn.prepareStatement(updateQuery)) {
			// Set flat attributes in the update statement
			updateStmt.setString(1, flatModel.getName());
			updateStmt.setString(2, flatModel.getCategory());
			updateStmt.setInt(3, flatModel.getPrice());
			updateStmt.setInt(4, flatModel.getSize());
			updateStmt.setInt(5, flatModel.getLivingroom());
			updateStmt.setInt(6, flatModel.getBedroom());
			updateStmt.setInt(7, flatModel.getKitchen());
			updateStmt.setString(8, flatModel.getFurnishing());
			updateStmt.setString(9, flatModel.getImage_Path());
			updateStmt.setString(10, flatModel.getStatus());
			updateStmt.setInt(11, flatModel.getFlat_Id()); // Set flat ID for WHERE clause

			// Execute update query
			return updateStmt.executeUpdate() > 0;

		} catch (SQLException e) {
			System.err.println("Error during flat update: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Deletes a flat from the database based on its flat ID.
	 *
	 * @param flatId the unique ID of the flat to be deleted
	 * @return Boolean indicating the success of the delete operation
	 */
	public Boolean deleteFlat(int flatId) {
		if (dbConn == null) {
			System.err.println("Database connection is not available.");
			return null;
		}

		String deleteQuery = "DELETE FROM flat WHERE flat_id = ?";

		try (PreparedStatement deleteStmt = dbConn.prepareStatement(deleteQuery)) {

			// Set the flat ID to delete
			deleteStmt.setInt(1, flatId);

			// Execute delete query
			return deleteStmt.executeUpdate() > 0;

		} catch (SQLException e) {
			System.err.println("Error during flat deletion: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
