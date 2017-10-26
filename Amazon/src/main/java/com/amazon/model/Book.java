package com.amazon.model;

import java.time.LocalDateTime;

public class Book extends Product{

	private int genres_id;
	private int authors_id;
	
	public Book(String name, String description, double price, LocalDateTime date, int quantaty, int raiting,
			int category_id, int genres_id, int authors_id) {
		super(name, description, price, date, quantaty, raiting, category_id);
		this.genres_id = genres_id;
		this.authors_id = authors_id;
	}

	public int getGenres_id() {
		return genres_id;
	}

	public void setGenres_id(int genres_id) {
		this.genres_id = genres_id;
	}

	public int getAuthors_id() {
		return authors_id;
	}

	public void setAuthors_id(int authors_id) {
		this.authors_id = authors_id;
	}

}
