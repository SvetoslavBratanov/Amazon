package com.amazon.model;

import java.sql.Date;

public class Movie extends Product{
	private int movieId;
	private String language;
	private int runTimeInMinutes;
	


	public Movie(String productName, String description, double price, Date publishDate, int quantaty, int categoriesID,
			String poster, String language, int runTimeInMinutes) {
		super(productName, description, price, publishDate, quantaty, categoriesID, poster);
		this.language = language;
		this.runTimeInMinutes = runTimeInMinutes;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getRunTimeInMinutes() {
		return runTimeInMinutes;
	}

	public void setRunTimeInMinutes(int runTimeInMinutes) {
		this.runTimeInMinutes = runTimeInMinutes;
	}
}
