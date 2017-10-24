package com.amazon.model;

import java.time.LocalDateTime;

public class Movie extends Product{
	private int genres_id;
	private int run_time_int_minutes;
	private String language; 
	
	public Movie(String name, String description, double price, LocalDateTime date, int quantaty, int raiting,
			int category_id, int genres_id, int run_time_in_minutes, String language) {
		super(name, description, price, date, quantaty, raiting, category_id);
		this.genres_id = genres_id;
		this.run_time_int_minutes = run_time_in_minutes;
		this.language = language;
	}

	public int getGenres_id() {
		return genres_id;
	}

	public void setGenres_id(int genres_id) {
		this.genres_id = genres_id;
	}

	public int getRun_time_int_minutes() {
		return run_time_int_minutes;
	}

	public void setRun_time_int_minutes(int run_time_int_minutes) {
		this.run_time_int_minutes = run_time_int_minutes;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
