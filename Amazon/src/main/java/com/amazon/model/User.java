package com.amazon.model;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;

	public User(String name, String password, String email) {
		this.id = 0;
		this.name = name;
		this.password = password;
		this.email = email;
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

	public void setPassword(String password) {
		if (validateString(password)) {
			this.password = password;
		}
	}

	public void setEmail(String email) {
		if (validateString(email)) {
			this.email = email;
		}
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	private static boolean validateString(String string) {
		return (string != null) && (string.length() > 0);
	}

}
