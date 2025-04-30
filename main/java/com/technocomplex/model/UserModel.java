package com.technocomplex.model;

import java.time.LocalDate;

public class UserModel {

	private int userId;
	private String name;
	private String phone;
	private String email;
	private LocalDate dob;
	private String gender;
	private String userName;
	private String password;
	private String role;
	private String profileImageUrl;

	
	public UserModel() {
		
	}
	/**
	 * @param userId
	 * @param name
	 * @param phone
	 * @param email
	 * @param dob
	 * @param gender
	 * @param userName
	 * @param password
	 * @param role
	 * @param profileImageUrl
	 */
	public UserModel(int userId, String name, String phone, String email, LocalDate dob, String gender, String userName,
			String password, String role, String profileImageUrl) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.profileImageUrl = profileImageUrl;
	}
	/**
	 * @param userId
	 * @param name
	 * @param phone
	 * @param email
	 * @param dob
	 * @param gender
	 * @param userName
	 * @param password
	 * @param profileImageUrl
	 */
	public UserModel(int userId, String name, String phone, String email, LocalDate dob, String gender,
			String userName, String password, String profileImageUrl) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.userName = userName;
		this.password = password;
		this.profileImageUrl = profileImageUrl;
	}
	/**
	 * @param name
	 * @param phone
	 * @param email
	 * @param dob
	 * @param gender
	 * @param userName
	 * @param password
	 * @param profileImageUrl
	 */
	public UserModel (String name, String phone, String email, LocalDate dob, String gender,
			String userName, String password, String profileImageUrl) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.userName = userName;
		this.password = password;
		this.profileImageUrl = profileImageUrl;
	}
	
	
	/**
	 * 
	 * @param userName
	 * @param password
	 */
	public UserModel (String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the number to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the profileImageUrl
	 */
	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	/**
	 * @param profileImageUrl the profileImageUrl to set
	 */
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

}
