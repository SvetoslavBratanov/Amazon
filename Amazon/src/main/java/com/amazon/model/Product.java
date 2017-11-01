package com.amazon.model;

import java.sql.Date;
import java.time.LocalDateTime;

import com.amazon.exception.ProductException;

public class Product {
	private int product_id;
	private String name;
	private String description;
	private double price;
	private LocalDateTime date;
	private int quantaty;
	private int raiting;
	private int category_id;
	private String poster;
	
	public Product( String name, String description, double price, LocalDateTime date, int quantaty,
			int raiting, int category_id, String poster) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.date = date;
		this.quantaty = quantaty;
		this.raiting = raiting;
		this.category_id = category_id;
		this.poster = poster;
	}

	public Product(int int1, String string, String string2, double double1, Date date2, int int2, int int3, int int4,
			String string3, int int5) {
		// TODO Auto-generated constructor stub
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) throws ProductException {
		if(product_id > 0) {
		this.product_id = product_id;
		} else {
			throw new ProductException("Invalid product_id");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws ProductException {
		if(validateString(name)) {
			this.name = name;
			} else {
				throw new ProductException("Invalid name");
			}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws ProductException {
		if(validateString(description)) {
			this.description = description;
			} else {
				throw new ProductException("Invalid description");
			}	
		}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws ProductException {
		if(price > 0) {
			this.price = price;
			} else {
				throw new ProductException("Invalid price");
			}		
		}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getQuantaty() {
		return quantaty;
	}

	public void setQuantaty(int quantaty) {
		this.quantaty = quantaty;
	}

	public int getRaiting() {
		return raiting;
	}

	public void setRaiting(int raiting) {
		this.raiting = raiting;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	

	private static boolean validateString(String string) {
		return (string != null);
	}
}
