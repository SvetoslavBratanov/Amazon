package com.amazon.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Pattern;

import com.amazon.exception.InvalidInfoException;

public class Book extends Product{

	private int bookID;
	private String authorName;
	private String genre;

	public int getBookID() {
		return bookID;
	}

	public Book(int productID, String productName, String description, double price, LocalDate publishDate, int quantaty,
			int timesSold, int starRaiting, int categoriesID, String poster,
			String authorName, String genre) throws InvalidInfoException {
		super(productID, productName, description, price, publishDate, quantaty, timesSold, starRaiting, categoriesID, poster);
		this.bookID = this.getProductID();
		this.setAuthorName(authorName);
		this.setGenre(genre);
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
	

	
	
}
