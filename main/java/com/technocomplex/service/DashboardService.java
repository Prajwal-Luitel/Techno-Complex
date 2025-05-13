package com.technocomplex.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.technocomplex.config.DbConfig;
import com.technocomplex.model.User_FlatModel;

public class DashboardService {

	private Connection dbConn;
	private boolean isConnectionError = false;

	public DashboardService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	/**
	 * Retrieves a list of flats currently booked by users, including user and flat
	 * details.
	 *
	 * @return A list of User_FlatModel objects representing user-flat bookings, or
	 *         null if there is a connection error
	 */
	public List<User_FlatModel> getUserFlatInformation() {
		if (isConnectionError) {
			return null;
		}

		String query = "SELECT u.user_id, u.profile_path, u.name AS uname, f.flat_Id, f.name AS fname, uf.move_In_Date, f.image_Path "
				+ "FROM user u JOIN user_flat uf ON u.user_id = uf.user_Id " + "JOIN flat f ON uf.flat_Id = f.flat_Id";
		List<User_FlatModel> userFlatList = new ArrayList<>();
		try (PreparedStatement selectStmt = dbConn.prepareStatement(query)) {
			ResultSet result = selectStmt.executeQuery();

			while (result.next()) {
				userFlatList.add(new User_FlatModel(result.getInt("user_id"), result.getString("profile_path"),
						result.getString("uname"), result.getInt("flat_Id"), result.getString("fname"),
						result.getDate("move_In_Date").toLocalDate(), result.getString("image_Path")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userFlatList;
	}

	/**
	 * Returns the most frequently booked flat category based on user bookings.
	 *
	 * @return The name of the most popular flat category, or null if not found or
	 *         on connection error
	 */
	public String getPopularFlatCategory() {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}

		String query = "SELECT f.category, COUNT(*) AS total_bookings " + "FROM flat f "
				+ "JOIN user_flat uf ON f.flat_Id = uf.flat_Id " + "GROUP BY f.category "
				+ "ORDER BY total_bookings DESC " + "LIMIT 1;";

		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				return result.getString("category");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Calculates and returns the total monthly revenue from all booked flats.
	 *
	 * @return The total monthly revenue as a string, or null if the query fails or
	 *         there is a connection error
	 */
	public String getMonthlyRevenue() {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}

		String query = "SELECT SUM(f.price) AS monthly_revenue " + "FROM flat f "
				+ "JOIN user_flat uf ON f.flat_Id = uf.flat_Id;";
		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				return result.getString("monthly_revenue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Retrieves the highest price among all flats in the database.
	 *
	 * @return The maximum flat price, or null if the query fails or there is a
	 *         connection error
	 */
	public Integer getHigestFlatPrice() {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}

		String query = "SELECT MAX(price) FROM flat;";
		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				return result.getInt("MAX(price)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Retrieves the name of the most recently booked flat based on the move-in
	 * date.
	 *
	 * @return The name of the recently booked flat, or null if not found or on
	 *         connection error
	 */
	public String getRecentlyBookedFlat() {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}

		String query = "SELECT f.name " + "FROM flat f " + "JOIN user_flat uf ON f.flat_Id = uf.flat_Id "
				+ "ORDER BY uf.move_In_Date DESC " + "LIMIT 1;";
		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				return result.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Counts how many flats have been booked in the current month.
	 *
	 * @return The number of flats booked this month, or null if the query fails or
	 *         there is a connection error
	 */
	public Integer getFlatBookedThisMonth() {
		if (isConnectionError) {
			System.out.println("Connection Error!");
			return null;
		}

		String query = "SELECT COUNT(*) AS flats_booked " + "FROM user_flat "
				+ "WHERE MONTH(move_In_Date) = MONTH(CURRENT_DATE) " + "  AND YEAR(move_In_Date) = YEAR(CURRENT_DATE);";

		try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				return result.getInt("flats_booked");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
