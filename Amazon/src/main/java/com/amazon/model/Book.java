package com.amazon.model;

import java.sql.Date;
import java.util.regex.Pattern;

import com.amazon.exception.InvalidInfoException;

public class Book extends Product{

	private int bookID;
	private String authorName;
	private String genre;
	
	public Book(String productName, String description, double price, Date publishDate, int quantaty, int categoriesID,
			String poster, int bookID, String authorName, String genre) throws InvalidInfoException {
		super(productName, description, price, publishDate, quantaty, categoriesID, poster);
		this.bookID = bookID;
		this.setAuthorName(authorName);
		this.setGenre(genre);
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) throws InvalidInfoException {
		if(validateSring(authorName)) {
			this.authorName = authorName;
		} else {
			throw new InvalidInfoException("Invalid genre");
		}
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	

	public static boolean isValidAuthor(String name) {
		Pattern pattern = Pattern.compile("[A-Za-z ]+"); 
		return (name != null) && pattern.matcher(name).matches() && name.length() > 3;
	}
	
	
}
