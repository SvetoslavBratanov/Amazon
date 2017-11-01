package com.amazon.model;

import java.time.LocalDateTime;

public class Computer extends Product{
	private int ram;
	private int ssd;
	private String processor;
	private String operation_system;
	public Computer(String name, String description, double price, LocalDateTime date, int quantaty, int raiting,
			int category_id, int ram, int ssd, String processor, String operation_system, String poster) {
		super(name, description, price, date, quantaty, raiting, category_id, poster);
		this.operation_system = operation_system;
		this.ssd = ssd;
		this.processor = processor;
		this.ram = ram;
	}
	public Computer(String name, String description, double price, LocalDateTime now, int quantaty, int raiting,
			int category_id, String poster) {
		super(name, description, price, now, quantaty, raiting, category_id, poster);
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getSsd() {
		return ssd;
	}
	public void setSsd(int ssd) {
		this.ssd = ssd;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getOperation_system() {
		return operation_system;
	}
	public void setOperation_system(String operation_system) {
		this.operation_system = operation_system;
	}

}
