package com.amazon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazon.db_connection.DBConnection;
import com.amazon.exception.InvalidInfoException;
import com.amazon.model.Book;
import com.amazon.model.Computer;
import com.amazon.model.Movie;
import com.amazon.model.Product;



@Service
public class SearchDao extends AbstractDAO{
	private static final String PREFIX_IMAGES= "/resources/static";
	public List<Movie> getAllMovies() throws InvalidInfoException {
		List<Movie> movies = new ArrayList<>();
		try {
			String query = "SELECT * FROM amazing.products p JOIN amazing.movies k ON (p.product_id = movie_id)";
			Statement st = this.getConnection().createStatement();
			ResultSet res = st.executeQuery(query);

			while (res.next()) {
				String productName = res.getString("product_name");
				String description = res.getString("description");
				LocalDate publishDate = res.getDate("publish_date").toLocalDate();
				String language = res.getString("language");
				double price = res.getDouble("price");
				int quantaty = res.getInt("quantity");
				int runTimeInMinutes = res.getInt("run_time_in_minutes");
				int categoriesID = res.getInt("categories_id");
				String poster = PREFIX_IMAGES +  res.getString("poster");
				movies.add(new Movie(productName, description, price, publishDate, quantaty, categoriesID, poster, language, runTimeInMinutes));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return movies;

	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		Statement st = null;
		try {
			 st = this.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "SELECT * FROM amazing.products p JOIN amazing.books k ON (p.product_id = book_id)";
		try {
			ResultSet res = st.executeQuery(query);
			while (res.next()) {

				while (res.next()) {
					String productName = res.getString("product_name");
					String description = res.getString("description");
					LocalDate publishDate = res.getDate("publish_date").toLocalDate();
					double price = res.getDouble("price");
					int quantaty = res.getInt("quantity");
					int categoriesID = res.getInt("categories_id");
					String poster = PREFIX_IMAGES + res.getString("poster");
					int bookID = res.getInt("book_id");
					String authorName = res.getString("author_name");
					String genre = res.getString("genre");
							

				try {
					books.add(new Book(productName, description, price, publishDate, quantaty, categoriesID, poster, bookID, authorName, genre));
				} catch (InvalidInfoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public List<Computer> getAllComputers() {
		List<Computer> computers = new ArrayList<>();
		Statement st = null;
		try {
			st = this.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT * From amazing.products p JOIN amazing.computers k ON (p.product_id = k.computers_id);";
				
		try {
			ResultSet res = st.executeQuery(query);
			while (res.next()) {

				String productName = res.getString("product_name");
				String description = res.getString("description");
				LocalDate publishDate = res.getDate("publish_date").toLocalDate();
				double price = res.getDouble("price");
				int quantaty = res.getInt("quantity");
				int categoriesID = res.getInt("categories_id");
				String poster =  PREFIX_IMAGES  + res.getString("poster");
				int ssd = res.getInt("SSD");
				int ram = res.getInt("ram");
				String operationSystem = res.getString("operation_system");
				String processor = res.getString("processor");
				try {
					computers.add(new Computer(productName, description, price, publishDate, quantaty, categoriesID, poster, operationSystem, ssd, ram, processor));
				} catch (InvalidInfoException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return computers;
	}

	public List<Product> getProductByName(String string) {
		List<Product> products = new ArrayList<>();
		Connection connection = DBConnection.getInstance().getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = "SELECT * From amazing.products WHERE product_name LIKE '%" + string
				+ "%'\n OR description  LIKE '%" + string + "%'\n;";

		try {
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				String productName = res.getString("product_name");
				String description = res.getString("description");
				LocalDate publishDate = res.getDate("publish_date").toLocalDate();
				double price = res.getDouble("price");
				int quantaty = res.getInt("quantity");
				int categoriesID = res.getInt("categories_id");
				String poster =  PREFIX_IMAGES  + res.getString("poster");

				products.add(new Product(productName, description, price, publishDate, quantaty, categoriesID, poster));
			}
		} catch (SQLException | InvalidInfoException e) {
			System.out.println(e.getMessage());
		}

		return products;
	}
	
	public List<Product> getProductByPrice(double from, double to ) {

		List<Product> products = new ArrayList<>();
		Connection connection = DBConnection.getInstance().getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = " SELECT * From amazing.products WHERE products.price BETWEEN " + from + "and "+to;

		try {
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				String productName = res.getString("product_name");
				String description = res.getString("description");
				LocalDate publishDate = res.getDate("publish_date").toLocalDate();
				double price = res.getDouble("price");
				int quantaty = res.getInt("quantity");
				int categoriesID = res.getInt("categories_id");
				String poster =  PREFIX_IMAGES  + res.getString("poster");

				products.add(new Product(productName, description, price, publishDate, quantaty, categoriesID, poster));
			}
		} catch (SQLException | InvalidInfoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(products);
		
		return products;
	}

}
