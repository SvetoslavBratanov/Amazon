package com.amazon.model;

import com.amazon.exception.InvalidInfoException;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private boolean isAdmin;
	private String phoneNumber;
	private Address address;
	
	public User() {
		
	}

	public User(String name, String password, String email) throws InvalidInfoException {
		this.id = 0;
		this.setName(name);
		this.setPassword(password);
		this.setEmail(email);
	}

	

	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) throws InvalidInfoException {
		
		if (validateString(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new InvalidInfoException();
		}
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) throws InvalidInfoException {
		if (validateString(password)) {
			this.password = password;
		} else {
			throw new InvalidInfoException();
		}
	}

	public void setEmail(String email) throws InvalidInfoException {
		if (validateString(email) ) {
			this.email = email;
		} else {
			throw new InvalidInfoException();
		}
	}

	public String getName() {
		return name;
	}


	public void setName(String name) throws InvalidInfoException {
		if (validateString(email)) {
			this.name = name;
		} else {
			throw new InvalidInfoException();
		}
	}


	private static boolean validateString(String string) {
		return (string != null) && (string.length() > 5);
	}



	public boolean isAdmin() {
		return isAdmin;
	}



	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	

}
