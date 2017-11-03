package com.amazon.model;

import java.sql.Date;
import java.time.LocalDateTime;

import com.amazon.exception.ProductException;


public class Product {
	
	private int productID;
	private String productName;
	private String description;
	private double price;
	private Date publishDate;
	private int quantaty;
	private int timesSold;
	private int starRaiting;
	private int categoriesID;
	private String poster;
	


	public Product(String productName, String description, double price, Date publishDate, int quantaty, int categoriesID, String poster) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.publishDate = publishDate;
		this.quantaty = quantaty;
		this.timesSold = 0;
		this.starRaiting = 0;
		this.categoriesID = categoriesID;
		this.poster = poster;
	}



	private static boolean validateString(String string) {
		return (string != null);
	}



	public int getProductID() {
		return productID;
	}



	public void setProductID(int productID) {
		this.productID = productID;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Date getPublishDate() {
		return publishDate;
	}



	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}



	public int getQuantaty() {
		return quantaty;
	}



	public void setQuantaty(int quantaty) {
		this.quantaty = quantaty;
	}



	public int getTimesSold() {
		return timesSold;
	}



	public void setTimesSold(int timesSold) {
		this.timesSold = timesSold;
	}



	public int getStarRaiting() {
		return starRaiting;
	}



	public void setStarRaiting(int starRaiting) {
		this.starRaiting = starRaiting;
	}



	public int getCategoriesID() {
		return categoriesID;
	}



	public void setCategoriesID(int categoriesID) {
		this.categoriesID = categoriesID;
	}



	public String getPoster() {
		return poster;
	}



	public void setPoster(String poster) {
		this.poster = poster;
	}
}
