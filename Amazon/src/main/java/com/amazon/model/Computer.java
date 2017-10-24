package com.amazon.model;

import java.time.LocalDateTime;

public class Computer extends Product{
	private int ram;
	private int ssd;
	private String processor;
	private String operation_system;
	public Computer(String name, String description, double price, LocalDateTime date, int quantaty, int raiting,
			int category_id, int ram, int ssd, String processor, String operation_system) {
		super(name, description, price, date, quantaty, raiting, category_id);
		this.operation_system = operation_system;
		this.ssd = ssd;
		this.processor = processor;
		this.ram = ram;
	}

}
