package com.amazon.model;


public class Address {
	
	private int id;
	private String street;
	private int number;
	private City city;
	
	
	public Address(int id, String street, int number, City city) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
}
