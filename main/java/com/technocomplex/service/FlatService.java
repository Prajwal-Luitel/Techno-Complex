package com.technocomplex.service;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.technocomplex.config.DbConfig;
import com.technocomplex.model.FlatModel;

public class FlatService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor initializes the database connection. Sets the connection error
	 * flag if the connection fails.
	 */
	public FlatService() {
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
	 * @return a list of available FlatModel objects, or null if a connection error
	 *         occurs.
	 */
	public List<FlatModel> getFlatList() {
		if (isConnectionError) {
			return null;
		}

		List<FlatModel> flatList = new ArrayList<>();
		String query = "SELECT * FROM flat";

		try (PreparedStatement selectStmt = dbConn.prepareStatement(query);
				ResultSet result = selectStmt.executeQuery()) {

			while (result.next()) {
				flatList.add(new FlatModel(result.getString("name"), result.getString("category"),
						result.getInt("price"), result.getInt("size"), result.getInt("living"),
						result.getInt("bedroom"), result.getInt("kitchen"), result.getString("furnishing"),
						result.getString("image_Path")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flatList;
	}

	/**
	 * Searches for available flats in the database based on the search query,
	 * category, and sorting order. Optionally filters by category, and can sort the
	 * results by price.
	 *
	 * @param searchQuery The text to search for in the flat names
	 * @param category    to filter by
	 * @param sort        by sorting preference; use "high" to sort by price
	 *                    descending, otherwise no sorting is applied
	 * @return A list of FlatModel objects matching the search criteria, or null if
	 *         there is a connection error
	 */
	public List<FlatModel> searchFlatList(String searchQuery, String category, String sort) {
		if (isConnectionError) {
			return null;
		}
		List<FlatModel> flatList = new ArrayList<>();
		StringBuilder query = new StringBuilder("SELECT * FROM flat WHERE status = 'available' AND LOWER(name) LIKE ?");
		// Apply category filter
		if (category != null && !category.equals("any")) {
			query.append(" AND category = ?");
		}
		// Apply sort
		if (sort.equals("high")) {
			query.append(" ORDER BY price DESC");
		}
		try (PreparedStatement stmt = dbConn.prepareStatement(query.toString())) {
			stmt.setString(1, "%" + searchQuery.toLowerCase() + "%");
			if (category != null && !category.equals("any")) {
				stmt.setString(2, category);
			}
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				flatList.add(new FlatModel(result.getString("name"), result.getString("category"),
						result.getInt("price"), result.getInt("size"), result.getInt("living"),
						result.getInt("bedroom"), result.getInt("kitchen"), result.getString("furnishing"),
						result.getString("image_Path")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flatList;
	}
}
