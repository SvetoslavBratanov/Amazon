package com.amazon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class SearchDao extends AbstractDAO {

	private static final String PREFIX_IMAGES = "/resources/static";
	private static final String GET_ALL_BOOKS = "SELECT * FROM amazing.products p JOIN amazing.books k ON (p.product_id = book_id)";
	private static final String GET_ALL_COMPUTERS = "SELECT * FROM amazing.products p JOIN amazing.computers k ON (p.product_id = k.computer_id)";
	private static final String GET_ALL_MOVIES = "SELECT * FROM amazing.products p JOIN amazing.movies k ON (p.product_id = movie_id)";

	public List<Movie> getAllMovies() throws InvalidInfoException, SQLException {
		List<Movie> movies = new ArrayList<>();
		ResultSet res = null;
		try (Statement st = this.getConnection().createStatement()) {

			res = st.executeQuery(GET_ALL_MOVIES);

			int indexProductID = res.findColumn("product_id");
			int indexProductName = res.findColumn("product_name");
			int indexDescription = res.findColumn("description");
			int indexPrice = res.findColumn("price");
			int indexPublishDate = res.findColumn("publish_date");
			int indexQuantity = res.findColumn("quantity");
			int indexTimesSold = res.findColumn("times_sold");
			int indexStarRaiting = res.findColumn("star_raiting");
			int indexPoster = res.findColumn("poster");
			int indexCategoriesID = res.findColumn("categories_id");

			while (res.next()) {

				int productID = res.getInt(indexProductID);
				String productName = res.getString(indexProductName);
				String description = res.getString(indexDescription);
				double price = res.getDouble(indexPrice);
				LocalDate publishDate = res.getDate(indexPublishDate).toLocalDate();
				int quantity = res.getInt(indexQuantity);
				int timesSold = res.getInt(indexTimesSold);
				int starRaiting = res.getInt(indexStarRaiting);
				String poster = PREFIX_IMAGES + res.getString(indexPoster);
				int categoriesID = res.getInt(indexCategoriesID);

				String language = res.getString("language");
				int runTimeInMinutes = res.getInt("run_time_in_minutes");

				movies.add(new Movie(productID, productName, description, price, publishDate, quantity, timesSold,
						starRaiting, categoriesID, poster, language, runTimeInMinutes));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movies;
	}

	public List<Book> getAllBooks() throws InvalidInfoException, SQLException {
		List<Book> books = new ArrayList<>();
		ResultSet res = null;
		try (Statement st = this.getConnection().createStatement()) {

			res = st.executeQuery(GET_ALL_BOOKS);
			int indexProductID = res.findColumn("product_id");
			int indexProductName = res.findColumn("product_name");
			int indexDescription = res.findColumn("description");
			int indexPrice = res.findColumn("price");
			int indexPublishDate = res.findColumn("publish_date");
			int indexQuantity = res.findColumn("quantity");
			int indexTimesSold = res.findColumn("times_sold");
			int indexStarRaiting = res.findColumn("star_raiting");
			int indexPoster = res.findColumn("poster");
			int indexCategoriesID = res.findColumn("categories_id");

			while (res.next()) {

				int productID = res.getInt(indexProductID);
				String productName = res.getString(indexProductName);
				String description = res.getString(indexDescription);
				double price = res.getDouble(indexPrice);
				LocalDate publishDate = res.getDate(indexPublishDate).toLocalDate();
				int quantity = res.getInt(indexQuantity);
				int timesSold = res.getInt(indexTimesSold);
				int starRaiting = res.getInt(indexStarRaiting);
				String poster = PREFIX_IMAGES + res.getString(indexPoster);
				int categoriesID = res.getInt(indexCategoriesID);

				String authorName = res.getString("author_name");
				String genre = res.getString("genre");

				books.add(new Book(productID, productName, description, price, publishDate, quantity, timesSold,
						starRaiting, categoriesID, poster, authorName, genre));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return books;
	}

	public List<Computer> getAllComputers() {
		List<Computer> computers = new ArrayList<>();
		ResultSet res = null;
		try (Statement st = this.getConnection().createStatement()) {

			res = st.executeQuery(GET_ALL_COMPUTERS);
			int indexProductID = res.findColumn("product_id");
			int indexProductName = res.findColumn("product_name");
			int indexDescription = res.findColumn("description");
			int indexPrice = res.findColumn("price");
			int indexPublishDate = res.findColumn("publish_date");
			int indexQuantity = res.findColumn("quantity");
			int indexTimesSold = res.findColumn("times_sold");
			int indexStarRaiting = res.findColumn("star_raiting");
			int indexPoster = res.findColumn("poster");
			int indexCategoriesID = res.findColumn("categories_id");

			while (res.next()) {

				int productID = res.getInt(indexProductID);
				String productName = res.getString(indexProductName);
				String description = res.getString(indexDescription);
				double price = res.getDouble(indexPrice);
				LocalDate publishDate = res.getDate(indexPublishDate).toLocalDate();
				int quantity = res.getInt(indexQuantity);
				int timesSold = res.getInt(indexTimesSold);
				int starRaiting = res.getInt(indexStarRaiting);
				String poster = PREFIX_IMAGES + res.getString(indexPoster);
				int categoriesID = res.getInt(indexCategoriesID);

				int ssd = res.getInt("SSD");
				int ram = res.getInt("RAM");
				String operationSystem = res.getString("operation_system");
				String processor = res.getString("processor");
				try {
					computers.add(new Computer(productID, productName, description, price, publishDate, quantity,
							timesSold, starRaiting, categoriesID, poster, operationSystem, ssd, ram, processor));
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
				int productID = res.getInt("product_id");
				String productName = res.getString("product_name");
				String description = res.getString("description");
				LocalDate publishDate = res.getDate("publish_date").toLocalDate();
				double price = res.getDouble("price");
				int quantaty = res.getInt("quantity");
				int timesSold = res.getInt("times_sold");
				int starRaiting = res.getInt("star_raiting");
				int categoriesID = res.getInt("categories_id");
				String poster = PREFIX_IMAGES + res.getString("poster");

				products.add(new Product(productID, productName, description, price, publishDate, quantaty, timesSold,
						starRaiting, categoriesID, poster));
			}
		} catch (SQLException | InvalidInfoException e) {
			System.out.println(e.getMessage());
		}

		return products;
	}

	public List<Product> getProductByPrice(double from, double to) {
	

		List<Product> products = new ArrayList<>();
		Connection connection = DBConnection.getInstance().getConnection();
		Statement st = null;
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String query = " SELECT * From amazing.products WHERE products.price BETWEEN " + from + "and " + to;

		try {
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				int productID = res.getInt("product_id");
				String productName = res.getString("product_name");
				String description = res.getString("description");
				LocalDate publishDate = res.getDate("publish_date").toLocalDate();
				double price = res.getDouble("price");
				int quantaty = res.getInt("quantity");
				int timesSold = res.getInt("times_sold");
				int starRaiting = res.getInt("star_raiting");
				int categoriesID = res.getInt("categories_id");
				String poster = PREFIX_IMAGES + res.getString("poster");

				products.add(new Product(productID, productName, description, price, publishDate,
						 quantaty, timesSold, starRaiting, categoriesID, poster));
			}
		} catch (SQLException | InvalidInfoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(products);

		return products;
	}

}
