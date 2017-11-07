package com.amazon.model;

import java.time.LocalDate;

import com.amazon.exception.InvalidInfoException;


public class Product {
	
	private int productID;
	private String productName;
	private String description;
	private double price;
	private LocalDate publishDate;
	private int quantity;
	private int timesSold;
	private int starRaiting;
	private int categoriesID;
	private String poster;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productID, String productName, String description, double price, LocalDate publishDate, int quantaty, int timesSold, int starRaiting, int categoriesID, String poster) throws InvalidInfoException {
		super();
		this.setProductID(productID);
		this.setProductName(productName); 
		this.setDescription(description);
		this.setPrice(price);
		this.setPublishDate(publishDate);
		this.setQuantaty(quantaty);
		this.setTimesSold(timesSold);
		this.setStarRaiting(starRaiting);
		this.setCategoriesID(categoriesID);
		this.setPoster(poster);
	}
	
	public Product(String productName, String description, double price, LocalDate publishDate, int quantaty,int categoriesID) {
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.publishDate = publishDate;
		this.quantity = quantaty;
		this.categoriesID = categoriesID;
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
	//	if(validateSring(productName)) {
			this.productName = productName;
//		} else {
//			throw new InvalidInfoException("Invalid product name");
//		}
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) throws InvalidInfoException {
//		if(validateSring(description)) {
			this.description = description;
//		} else {
//			throw new InvalidInfoException("Invalid description");
//		}	
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) throws InvalidInfoException {
		if(price > 0) {
			this.price = price;
		} else {
			throw new InvalidInfoException("Invalid price");
		}	
	}



	public LocalDate getPublishDate() {
		return publishDate;
	}



	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}



	public int getQuantaty() {
		return quantity;
	}



	public void setQuantaty(int quantaty) throws InvalidInfoException {
		if(quantaty >= 0) {
			this.quantity = quantaty;
		} else {
			throw new InvalidInfoException("Invalid quantity");

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

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", publishDate=" + publishDate + ", quantity=" + quantity + ", timesSold="
				+ timesSold + ", starRaiting=" + starRaiting + ", categoriesID=" + categoriesID + ", poster=" + poster
				+ "]";
	}

	public void setPoster(String poster) throws InvalidInfoException {
		if(poster.contains(".jpeg") || poster.contains(".png") || poster.contains(".jpg")){
			this.poster = poster;
		} else {
			throw new InvalidInfoException("Invalid image");
		}
	}
	
	public static boolean validateSring(String string) {
		return (string != null && string.length() > 3);

	}
}
