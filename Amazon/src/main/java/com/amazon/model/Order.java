package com.amazon.model;

import java.time.LocalDate;

public class Order {
	
	private int id;
	private String purchseNumber;
	private LocalDate date;
	private int userID;
	
	public Order(int id, String purchseNumber, LocalDate date, int userID) {
		super();
		this.id = id;
		this.purchseNumber = purchseNumber;
		this.date = date;
		this.userID = userID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPurchseNumber() {
		return purchseNumber;
	}

	public void setPurchseNumber(String purchseNumber) {
		this.purchseNumber = purchseNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
}
