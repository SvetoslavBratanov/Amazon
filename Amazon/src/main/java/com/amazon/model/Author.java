package com.amazon.model;

import com.amazon.exception.AuthorException;

public class Author {
	private int id;
	private String firstName;
	private String lastName;

	public Author(String firstName, String lastName) throws AuthorException {

		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author(int id, String firstName, String lastName) throws AuthorException {
		this(firstName, lastName);
		setId(id);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws AuthorException {
		if (firstName != null && !firstName.trim().isEmpty()) {
			this.firstName = firstName;
		} else {
			throw new AuthorException("Invalid author first name!");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws AuthorException {
		if (lastName != null && !lastName.trim().isEmpty()) {
			this.lastName = lastName;
		} else {
			throw new AuthorException("Invalid author last name!");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("First name: " + getFirstName());
		sb.append("Last name: " + getLastName());
		return sb.toString();
	}

}

