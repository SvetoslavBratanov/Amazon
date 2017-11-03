package com.amazon.model;

import com.amazon.exception.InvalidInfoException;

public class Comment {
	
	private String contain;
	private int starRaiting;
	private int productID;
	private int userID;
	
	public Comment(String contain,int productID, int userID) throws InvalidInfoException {
		super();
		setContain(contain);
		this.starRaiting = 0;
		this.productID = productID;
		this.userID = userID;
	}

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) throws InvalidInfoException {
		if(contain != null && !contain.isEmpty()) {
			this.contain = contain;
		} else {
			throw new InvalidInfoException();
		}
	}

	public int getStarRaiting() {
		return starRaiting;
	}

	public void setStarRaiting(int starRaiting) throws InvalidInfoException {
		if(starRaiting >= 0) {
			this.starRaiting = starRaiting;
		} else {
			throw new InvalidInfoException();
		}
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
