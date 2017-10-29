package com.amazon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazon.db_connection.DBConnection;
import com.amazon.model.Book;
import com.amazon.model.Movie;

@Service
public class SearchDao {

	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		try (Connection connection = DBConnection.getInstance().getConnection()) {
			String query = "SELECT * FROM movies";

			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				int id = res.getInt("id");
				int run_time_in_minutes = res.getInt("run_time_in_minutes");
				String name = res.getString("name");
				String language = res.getString("language");
				// trqbva da join-em s drugata tablica
				String genre = res.getString("genre");
				// Productite da sa final, v konstruktura sys set=eri i proverki

				//movies.add(new Movie(id, run_time_in_minutes, name, language));

			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}
	
	
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			Statement st = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "SELECT * FROM books";
		
		for(int i = 0; i < 100; i++) {
			books.add(new Book("kniga", "kniga", i, LocalDateTime.now(), 50, 80, 5, 58, 8));
		}
		return books;
	}
}
