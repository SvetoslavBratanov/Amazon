package com.amazon.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.amazon.exception.InvalidInfoException;

public class Order {
	
	private int orderID;
	private LocalDateTime date;
	private double amount;
	private int userID;
	
	
	public Order(LocalDateTime date, double amount, int userID) throws InvalidInfoException {
		super();
		this.date = date;
		setAmount(amount);
		setUserID(userID);
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) throws InvalidInfoException {
		if(amount > 0) {
			this.amount = amount;
		} else {
			throw new InvalidInfoException("Invalid amount of order!");
		}
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) throws InvalidInfoException {
		if(userID > 0) {
			this.userID = userID;
		} else {
			throw new InvalidInfoException("Invalid userID in order!");
		}
	}
	
	
	
	
}
