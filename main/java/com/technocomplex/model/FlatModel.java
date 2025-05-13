
package com.technocomplex.model;

public class FlatModel {

	private int flat_Id;
    private String name;
    private String category;
	private int price;
	private int size;
	private int livingroom;
	private int bedroom;
	private int kitchen;
	private String furnishing;
	private String image_Path;
	private String status;
	
	/**
	 * 
	 */
	public FlatModel() {
		super();
	}

	/**
	 * @param flat_Id
	 * @param name
	 * @param category
	 * @param price
	 * @param size
	 * @param livingroom
	 * @param bedroom
	 * @param kitchen
	 * @param furnishing
	 * @param image_Path
	 * @param status
	 */
	public FlatModel(int flat_Id,String name, String category,  int price, int size, int livingroom, int bedroom,
			int kitchen, String furnishing, String image_Path, String status) {
		super();
		this.flat_Id = flat_Id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.size = size;
		this.livingroom = livingroom;
		this.bedroom = bedroom;
		this.kitchen = kitchen;
		this.furnishing = furnishing;
		this.image_Path = image_Path;
		this.status = status;
	}

	/**
	 * @param name
	 * @param category
	 * @param price
	 * @param size
	 * @param livingroom
	 * @param bedroom
	 * @param kitchen
	 * @param furnishing
	 * @param image_Path
	 * @param status
	 */
	public FlatModel(String name, String category,  int price, int size, int livingroom, int bedroom,
			int kitchen, String furnishing, String image_Path, String status) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.size = size;
		this.livingroom = livingroom;
		this.bedroom = bedroom;
		this.kitchen = kitchen;
		this.furnishing = furnishing;
		this.image_Path = image_Path;
		this.status = status;
	}

	
	/**
	 * @param name
	 * @param category
	 * @param price
	 * @param size
	 * @param livingroom
	 * @param bedroom
	 * @param kitchen
	 * @param furnishing
	 * @param image_Path
	 */
	public FlatModel(String name, String category, int price, int size, int livingroom, int bedroom, int kitchen,
			String furnishing, String image_Path) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.size = size;
		this.livingroom = livingroom;
		this.bedroom = bedroom;
		this.kitchen = kitchen;
		this.furnishing = furnishing;
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
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * @return the furnishing
	 */
	public String getFurnishing() {
		return furnishing;
	}

	/**
	 * @param furnishing the furnishing to set
	 */
	public void setFurnishing(String furnishing) {
		this.furnishing = furnishing;
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

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
	
	
	
}
