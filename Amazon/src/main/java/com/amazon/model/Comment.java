package com.amazon.model;

public class Comment {
	
	private String contain;
	private int starRaiting;
	private int productID;
	private int userID;
	
	public Comment(String contain, int starRaiting, int productID, int userID) {
		super();
		this.contain = contain;
		this.starRaiting = starRaiting;
		this.productID = productID;
		this.userID = userID;
	}

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) {
		this.contain = contain;
	}

	public int getStarRaiting() {
		return starRaiting;
	}

	public void setStarRaiting(int starRaiting) {
		this.starRaiting = starRaiting;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
