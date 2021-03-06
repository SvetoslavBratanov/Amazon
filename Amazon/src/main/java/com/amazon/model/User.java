package com.amazon.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amazon.exception.InvalidInfoException;

public class User {
	private int userID;
	private String email;
	private String password;
	private String name;
	private String phoneNumber;
	private String address;
	private boolean isAdmin;

	public User() {

	}

	public User(String email, String password, String name) throws InvalidInfoException {
		super();
		setEmail(email);
		setPassword(password);
		setName(name);
		this.isAdmin = false;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws InvalidInfoException {
		if (isValidEmailAddress(email)) {
			this.email = email;
		} else {
			throw new InvalidInfoException("Invalid email address");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws InvalidInfoException {
		if(isValidPassword(password) ) {
			this.password = password;
		} else {
			throw new InvalidInfoException("Invalid password");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws InvalidInfoException {
		if(isValidName(name)) {
			this.name = name;
		} else {
			throw new InvalidInfoException("Invalid name");
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public static boolean isValidName(String name) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9_]+"); 
		return (name != null) && pattern.matcher(name).matches();
	}

	public static boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	
	public static boolean isValidPassword(String password) {
		Pattern letter = Pattern.compile("[a-zA-z]");
		Pattern digit = Pattern.compile("[0-9]");
		Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		Pattern countOfLetters = Pattern.compile(".{6,15}");
		
		Matcher hasLetter = letter.matcher(password);
		Matcher hasDigit = digit.matcher(password);
		Matcher hasSpecial = special.matcher(password);
		Matcher range = countOfLetters.matcher(password);
		return (hasLetter.find() || hasDigit.find() || hasSpecial.find()) && range.matches();
	}

}
