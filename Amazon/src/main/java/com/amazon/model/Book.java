package com.amazon.model;

import java.sql.Date;

public class Book extends Product{

	private int bookID;
	private String authorName;
	private String genre;
	
	public Book(String productName, String description, double price, Date publishDate, int quantaty, int categoriesID,
			String poster, int bookID, String authorName, String genre) {
		super(productName, description, price, publishDate, quantaty, categoriesID, poster);
		this.bookID = bookID;
		this.authorName = authorName;
		this.genre = genre;
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

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
