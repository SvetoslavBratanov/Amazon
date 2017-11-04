//package com.amazon.dao;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.amazon.db_connection.DBConnection;
//import com.amazon.model.Book;
//import com.amazon.model.Computer;
//import com.amazon.model.Movie;
//import com.amazon.model.Product;
//
//;
//
//@Service
//public class SearchDao {
//
//	public List<Movie> getAllMovies() {
//		List<Movie> movies = new ArrayList<>();
//		Connection connection = DBConnection.getInstance().getConnection();
//		try {
//			String query = "SELECT * FROM amazon.products p JOIN amazon.categories k ON (p.categories_id = k.id) WHERE category_name LIKE 'Pre-orders'";
//
//			Statement st = connection.createStatement();
//			ResultSet res = st.executeQuery(query);
//
//			while (res.next()) {
//				String name = res.getString("product_name");
//				String description = res.getString("description");
//				// String language = res.getString("language");
//				double price = res.getDouble("price");
//				int quantaty = res.getInt("quantity");
//				int category_id = res.getInt("categories_id");
//				int raiting = res.getInt("star_raiting");
//				// int run_time_in_minutes = res.getInt("run_time_in_minutes");
//				// int genres_id = res.getInt("genres_id");
//				String poster = res.getString("poster");
//				
//				// Timestamp date = res.getTimestamp("publish_date");
//
//				// movies.add(new Movie(name, description, price, LocalDateTime.now(), quantaty,
//				// raiting, category_id,
//				// genres_id, run_time_in_minutes, language, poster));
//				movies.add(new Movie(name, description, price, LocalDateTime.now(), quantaty, raiting, category_id,
//						poster));
//				System.err.println("dqvola napravi tozi metod");
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		}
//		return movies;
//
//	}
//
//	public List<Book> getAllBooks() {
//		List<Book> books = new ArrayList<>();
//		Connection connection = DBConnection.getInstance().getConnection();
//		Statement st = null;
//		try {
//			st = connection.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String query = "SELECT * From amazon.products p JOIN amazon.categories k ON (p.categories_id = k.id) WHERE k.category_name LIKE 'books';";
//		try {
//			ResultSet res = st.executeQuery(query);
//			while (res.next()) {
//				String name = res.getString("product_name");
//				String description = res.getString("description");
//				double price = res.getDouble("price");
//				int quantaty = res.getInt("quantity");
//				int category_id = res.getInt("categories_id");
//				// Timestamp date = res.getTimestamp("publish_date");
//				int raiting = res.getInt("star_raiting");
//				String poster = res.getString("poster");
//
//				books.add(new Book(name, description, price, LocalDateTime.now(), quantaty, raiting, category_id,
//						poster));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return books;
//	}
//
//	public List<Computer> getAllComputers() {
//		List<Computer> computers = new ArrayList<>();
//		Connection connection = DBConnection.getInstance().getConnection();
//		Statement st = null;
//		try {
//			st = connection.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		String query = "SELECT * From amazon.products p JOIN amazon.categories k ON (p.categories_id = k.id) "
//				+ "WHERE k.category_name LIKE 'laptops';";
//		try {
//			ResultSet res = st.executeQuery(query);
//			while (res.next()) {
//				String name = res.getString("product_name");
//				String description = res.getString("description");
//				double price = res.getDouble("price");
//				int quantaty = res.getInt("quantity");
//				int category_id = res.getInt("categories_id");
//				// int ram = res.getInt("RAM");
//				// int ssd = res.getInt("SSD");
//				// String operation_system = res.getString("operation_system");
//				int raiting = res.getInt("star_raiting");
//				// String processor = res.getString("processor");
//				// Timestamp date = res.getTimestamp("publish_date");
//				String poster = res.getString("poster");
//
//				// computers.add(new Computer(name, description, price, LocalDateTime.now(),
//				// quantaty, raiting,
//				// category_id, ram, ssd, processor, operation_system, poster));
//				computers.add(new Computer(name, description, price, LocalDateTime.now(), quantaty, raiting,
//						category_id, poster));
//				System.err.println("dqvola napravi tozi metod");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return computers;
//	}
//
//	public List<Product> getProductByName(String string) {
//		List<Product> products = new ArrayList<>();
//		Connection connection = DBConnection.getInstance().getConnection();
//		Statement st = null;
//		try {
//			st = connection.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		String query = "SELECT * From amazon.products WHERE product_name LIKE '%" + string
//				+ "%'\n OR description   LIKE '%" + string + "%'\n;";
//
//		try {
//			ResultSet res = st.executeQuery(query);
//			System.out.println("fscdnskdn");
//			int index = 0;
//			while (res.next()) {
//				String name = res.getString("product_name");
//				String description = res.getString("description");
//				double price = res.getDouble("price");
//				int quantaty = res.getInt("quantity");
//				int category_id = res.getInt("categories_id");
//				int raiting = res.getInt("star_raiting");
//				String poster = res.getString("poster");
//
//				products.add(new Product(name, description, price, LocalDateTime.now(), quantaty, raiting, category_id,
//						poster));
//				System.out.println(products.get(index++));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return products;
//	}

//}
