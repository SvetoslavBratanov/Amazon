package com.amazon.model;

import java.sql.Date;

public class Computer extends Product{
	private int computersID;
	private String operationSystem;
	private int ssd;
	private int ram;
	private String processor;
	private int category_id;
	
	public Computer(String productName, String description, double price, Date publishDate, int quantaty,
			int categoriesID, String poster, String operationSystem, int ssd, int ram, String processor,
			int category_id) {
		super(productName, description, price, publishDate, quantaty, categoriesID, poster);
		this.operationSystem = operationSystem;
		this.ssd = ssd;
		this.ram = ram;
		this.processor = processor;
		this.category_id = category_id;
	}

	public int getComputersID() {
		return computersID;
	}

	public void setComputersID(int computersID) {
		this.computersID = computersID;
	}

	public String getOperationSystem() {
		return operationSystem;
	}

	public void setOperationSystem(String operationSystem) {
		this.operationSystem = operationSystem;
	}

	public int getSsd() {
		return ssd;
	}

	public void setSsd(int ssd) {
		this.ssd = ssd;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	
}
