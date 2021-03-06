package com.amazon.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Pattern;

import com.amazon.exception.InvalidInfoException;

public class Movie extends Product{
	private static final int MAX_MOVIE_LENGHT = 20;
	private int movieId;
	private String language;
	private int runTimeInMinutes;
	

	public int getMovieId() {
		return movieId;
	}

	public Movie(int productID, String productName, String description, double price, LocalDate
			publishDate, int quantaty, int timesSold, int starRaiting, int categoriesID, 
			String poster, String language, int runTimeInMinutes) throws InvalidInfoException {
		super(productID, productName, description, price, publishDate, quantaty, timesSold, starRaiting, categoriesID, poster);
		this.movieId = this.getProductID();
		this.setLanguage(language);
		this.setRunTimeInMinutes(runTimeInMinutes);
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) throws InvalidInfoException {
		if(isValidLanguage(language)){
			this.language = language;
		} else {
			throw new InvalidInfoException("Invalid name of language");
		}
	}

	public int getRunTimeInMinutes() {
		return runTimeInMinutes;
	}

	public void setRunTimeInMinutes(int runTimeInMinutes) throws InvalidInfoException {
		if(runTimeInMinutes > MAX_MOVIE_LENGHT) {
			this.runTimeInMinutes = runTimeInMinutes;
		} else {
			throw new InvalidInfoException("invalid movie lenght");
		}
	}
	
	public static boolean isValidLanguage(String language) {
		Pattern pattern = Pattern.compile("[A-Za-z]+"); 
		return (language != null) && pattern.matcher(language).matches() && language.length() > 3;
	}
}
