package com.technocomplex.model;

public class FlatModel {

	private int flat_Id;
	private int floor;
	private int price;
	private int size;
	private int livingroom;
	private int bedroom;
	private int kitchen;
	private boolean isFurnished;
	private String image_Path;
	/**
	 * @param flat_Id
	 * @param floor
	 * @param price
	 * @param size
	 * @param livingroom
	 * @param bedroom
	 * @param kitchen
	 * @param isFurnished
	 * @param image_Path
	 */
	public FlatModel(int flat_Id, int floor, int price, int size, int livingroom, int bedroom, int kitchen,
			boolean isFurnished, String image_Path) {
		super();
		this.flat_Id = flat_Id;
		this.floor = floor;
		this.price = price;
		this.size = size;
		this.livingroom = livingroom;
		this.bedroom = bedroom;
		this.kitchen = kitchen;
		this.isFurnished = isFurnished;
		this.image_Path = image_Path;
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
	 * @return the floor
	 */
	public int getFloor() {
		return floor;
	}
	/**
	 * @param floor the floor to set
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the livingroom
	 */
	public int getLivingroom() {
		return livingroom;
	}
	/**
	 * @param livingroom the livingroom to set
	 */
	public void setLivingroom(int livingroom) {
		this.livingroom = livingroom;
	}
	/**
	 * @return the bedroom
	 */
	public int getBedroom() {
		return bedroom;
	}
	/**
	 * @param bedroom the bedroom to set
	 */
	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}
	/**
	 * @return the kitchen
	 */
	public int getKitchen() {
		return kitchen;
	}
	/**
	 * @param kitchen the kitchen to set
	 */
	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}
	/**
	 * @return the isFurnished
	 */
	public boolean isFurnished() {
		return isFurnished;
	}
	/**
	 * @param isFurnished the isFurnished to set
	 */
	public void setFurnished(boolean isFurnished) {
		this.isFurnished = isFurnished;
	}
	/**
	 * @return the image_Path
	 */
	public String getImage_Path() {
		return image_Path;
	}
	/**
	 * @param image_Path the image_Path to set
	 */
	public void setImage_Path(String image_Path) {
		this.image_Path = image_Path;
	}
	
	
}
