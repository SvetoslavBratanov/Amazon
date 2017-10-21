package com.amazon.model;

import java.time.LocalDateTime;

public class Product {
	private int product_id;
	private String name;
	private String description;
	private double price;
	private LocalDateTime date;
	private int quantaty;
	private int raiting;
	private int category_id;
	
	public Product( String name, String description, double price, LocalDateTime date, int quantaty,
			int raiting, int category_id) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.date = date;
		this.quantaty = quantaty;
		this.raiting = raiting;
		this.category_id = category_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
