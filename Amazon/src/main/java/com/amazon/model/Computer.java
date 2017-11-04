package com.amazon.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Pattern;

import com.amazon.exception.InvalidInfoException;

public class Computer extends Product{
	private int computersID;
	private String operationSystem;
	private int ssd;
	private int ram;
	private String processor;
	
	public Computer(String productName, String description, double price, LocalDate publishDate, int quantaty,
			int categoriesID, String poster, String operationSystem, int ssd, int ram, String processor) throws InvalidInfoException {
		super(productName, description, price, publishDate, quantaty, categoriesID, poster);
		this.operationSystem = operationSystem;
		this.ssd = ssd;
		this.ram = ram;
		this.processor = processor;
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

	public void setOperationSystem(String operationSystem) throws InvalidInfoException {
		if(isValidString(operationSystem)) {
			this.operationSystem = operationSystem;
		} else {
			throw new InvalidInfoException("invalid operation system");
		}
	}

	public int getSsd() {
		return ssd;
	}

	public void setSsd(int ssd) throws InvalidInfoException {
		if(ssd > 0) {
			this.ssd = ssd;
		} else {

			throw new InvalidInfoException("invalid ssd");
		}
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) throws InvalidInfoException {
		if(ram > 0) {
			this.ram = ram;
		} else {

			throw new InvalidInfoException("invalid ram");
		}
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) throws InvalidInfoException {
		if(isValidString(processor)) {
			this.processor = processor;
		} else {
			throw new InvalidInfoException("invalid processor");
		}
		this.processor = processor;
	}
	
	public static boolean isValidString(String name) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9 ]+"); 
		return (name != null) && pattern.matcher(name).matches() && name.length() > 3;
	}
	
	
}
