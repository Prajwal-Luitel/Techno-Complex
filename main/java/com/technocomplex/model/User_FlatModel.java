package com.technocomplex.model;

import java.time.LocalDate;

public class User_FlatModel {
    private int userId;
    private String profile;
    private String userName;
    private int flat_Id;
    private String flatName;
    private LocalDate Move_In_Date;
    private String flatImage;
	/**
	 * @param userId
	 * @param profile
	 * @param userName
	 * @param flat_Id
	 * @param flatName
	 * @param move_In_Date
	 * @param flatImage
	 */
	public User_FlatModel(int userId, String profile, String userName, int flat_Id, String flatName,
			LocalDate move_In_Date, String flatImage) {
		super();
		this.userId = userId;
		this.profile = profile;
		this.userName = userName;
		this.flat_Id = flat_Id;
		this.flatName = flatName;
		Move_In_Date = move_In_Date;
		this.flatImage = flatImage;
	}
	/**
	 * 
	 */
	public User_FlatModel() {
		super();
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the flatName
	 */
	public String getFlatName() {
		return flatName;
	}
	/**
	 * @param flatName the flatName to set
	 */
	public void setFlatName(String flatName) {
		this.flatName = flatName;
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
	/**
	 * @return the flatImage
	 */
	public String getFlatImage() {
		return flatImage;
	}
	/**
	 * @param flatImage the flatImage to set
	 */
	public void setFlatImage(String flatImage) {
		this.flatImage = flatImage;
	}
    
    
	
    
}
