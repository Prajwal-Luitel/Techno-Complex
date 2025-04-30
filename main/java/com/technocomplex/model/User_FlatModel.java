package com.technocomplex.model;

import java.time.LocalDate;

public class User_FlatModel {
    private int user_Id;
    private int flat_Id;
    private LocalDate Move_In_Date;
	/**
	 * @param user_Id
	 * @param flat_Id
	 * @param move_In_Date
	 */
	public User_FlatModel(int user_Id, int flat_Id, LocalDate move_In_Date) {
		super();
		this.user_Id = user_Id;
		this.flat_Id = flat_Id;
		Move_In_Date = move_In_Date;
	}
	/**
	 * @return the user_Id
	 */
	public int getUser_Id() {
		return user_Id;
	}
	/**
	 * @param user_Id the user_Id to set
	 */
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	/**
	 * @return the flat_Id
	 */
	public int getFlat_Id() {
		return flat_Id;
	}
	/**
	 * @param flat_Id the flat_Id to set
	 */
	public void setFlat_Id(int flat_Id) {
		this.flat_Id = flat_Id;
	}
	/**
	 * @return the move_In_Date
	 */
	public LocalDate getMove_In_Date() {
		return Move_In_Date;
	}
	/**
	 * @param move_In_Date the move_In_Date to set
	 */
	public void setMove_In_Date(LocalDate move_In_Date) {
		Move_In_Date = move_In_Date;
	}
    
    
}
