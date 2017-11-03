package com.amazon.model;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amazon.exception.InvalidInfoException;


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
	


	public Product(String productName, String description, double price, Date publishDate, int quantaty, int categoriesID, String poster) throws InvalidInfoException {
		super();
		this.setProductName(productName); 
		this.setDescription(description);
		this.setPrice(price);
		this.setPublishDate(publishDate);
		this.setQuantaty(quantaty);
		this.timesSold = 0;
		this.starRaiting = 0;
		this.setCategoriesID(categoriesID);
		this.setPoster(poster);
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



	public void setProductName(String productName) throws InvalidInfoException {
		if(validateSring(productName)) {
			this.productName = productName;
		} else {
			throw new InvalidInfoException("Invalid product name");
		}
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) throws InvalidInfoException {
		if(validateSring(description)) {
			this.description = description;
		} else {
			throw new InvalidInfoException("Invalid product name");
		}	
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) throws InvalidInfoException {
		if(this.price > 0) {
			this.price = price;
		} else {
			throw new InvalidInfoException("Invalid price");
		}	
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



	public void setQuantaty(int quantaty) throws InvalidInfoException {
		if(this.quantaty >= 0) {
			this.quantaty = quantaty;
		} else {
			throw new InvalidInfoException("Invalid quantaty");

		}
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



	public void setPoster(String poster) throws InvalidInfoException {
		if(poster.contains(".jpeg") || poster.contains(".png") || poster.endsWith(".")){
			this.poster = poster;
		} else {
			throw new InvalidInfoException("Invalid image");
		}
	}
	
	public static boolean validateSring(String txt) {
		//contains letters and special characters
	    String regx = "\"[A-Za-z0-9_]+";
	    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(txt);
	    return matcher.find();

	}
}
