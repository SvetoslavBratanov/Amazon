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
		Statement st = null;
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = "SELECT * From amazon.products p JOIN amazon.categories k ON (p.category_id = k.id) WHERE k.category_name LIKE 'books';";
		try {
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				String name = res.getString("product_name");
				String description = res.getString("description");
				double price = res.getDouble("price");
				int quantaty = res.getInt("quantity");
				int category_id = res.getInt("category_id");
				//int authors_id = res.getInt("author_id");
				int raiting = res.getInt("star_raiting");
				//int genres_id = res.getInt("genre_id");
				books.add(new Book(name, description, price, LocalDateTime.now(), quantaty, raiting, category_id));
				// Productite da sa final, v konstruktura sys set=eri i proverki

				//movies.add(new Movie(id, run_time_in_minutes, name, language));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(int i = 0; i < 100; i++) {
//			books.add(new Book("kniga", "kniga", i, LocalDateTime.now(), 50, 80, 5, 58, 8));
//		}
		return books;
	}
}
