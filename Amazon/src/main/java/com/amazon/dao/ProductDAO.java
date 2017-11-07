package com.amazon.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazon.exception.InvalidInfoException;
import com.amazon.model.Book;
import com.amazon.model.Computer;
import com.amazon.model.Movie;
import com.amazon.model.Product;


@Service
public class ProductDAO extends AbstractDAO implements IProductDAO {
	
	private static final String PREFIX_IMAGES = "/resources/static";
	private static final String GET_ALL_PRODUCTS = "SELECT * FROM amazing.products";
	private static final String INSERT_NEW_PRODUCT_QUERY = "INSERT INTO amazing.products"
			+ "(product_name, description, price, publish_date, quantity, times_sold, star_raiting, poster, categories_id) "
			+ "VALUES (?, ?, ?, ?, ?, 0, 0, ?, ?);";
	private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM amazing.products WHERE product_id = ?;";
	private static final String SET_NEW_QUANTITY_OF_PRODUCTS = "UPDATE amazing.products SET quantity = quantity - ? where product_id = ? AND quantity > 0";
	private static final String GET_MOVIE_BY_ID = "SELECT * FROM amazing.products JOIN amazing.movies WHERE product_id = ? AND movie_id = ?";
	private static final String GET_BOOK_BY_ID = "SELECT * FROM amazing.products JOIN amazing.books WHERE product_id = ? AND book_id = ?";
	private static final String GET_COMPUTER_BY_ID = "SELECT * FROM amazing.products JOIN amazing.computers WHERE product_id = ? AND computer_id = ?";
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		ResultSet res = null;
		try (Statement st = this.getConnection().createStatement()) {

			res = st.executeQuery(GET_ALL_PRODUCTS);

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

				products.add(new Product(productID, productName, description, price, publishDate, quantity, timesSold,
						starRaiting, categoriesID, poster));
			}
		} catch (SQLException | InvalidInfoException e) {
			e.printStackTrace();
		} finally {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	
	}
	
	@Override
	public void addProduct(Product product) throws SQLException {
		try(PreparedStatement ps = this.getConnection().prepareStatement(INSERT_NEW_PRODUCT_QUERY)) {
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setDate(4, Date.valueOf(product.getPublishDate()));			
			ps.setInt(5,product.getQuantaty());
			ps.setString(6, product.getPoster());
			ps.setInt(7,product.getCategoriesID());
			
			ps.execute();
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public PreparedStatement removeProductByIdAndQuantitynt(int productId, int quantity) throws SQLException {
		PreparedStatement psRemovedProduct = this.getConnection().prepareStatement(SET_NEW_QUANTITY_OF_PRODUCTS);
		psRemovedProduct.setInt(1, quantity);
		psRemovedProduct.setInt(2, productId);
		psRemovedProduct.executeUpdate();
		return psRemovedProduct;
	}

	@Override
	public Product getProductById(int id) {
		Product product = null;
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(GET_PRODUCT_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6),
					rs.getInt(7),rs.getInt(8),rs.getInt(10),rs.getString(9));
					
			
		} catch (SQLException | InvalidInfoException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	public Movie getMovieById(int id) {
		Movie movie = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement(GET_MOVIE_BY_ID);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int indexOfLanguage = rs.findColumn("language");
			int indexOfRunTimeInMinutes = rs.findColumn("run_time_in_minutes");
			movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6),
					rs.getInt(7),rs.getInt(8),rs.getInt(10),rs.getString(9),rs.getString(indexOfLanguage), rs.getInt(indexOfRunTimeInMinutes));
			
		} catch (SQLException | InvalidInfoException e) {
			e.printStackTrace();
		}
		return movie;
	}
     
	public Book getBookById(int id) {
		Book book = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement(GET_BOOK_BY_ID);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int indexOfAuthor = rs.findColumn("author_name");
			int indexOfGenre = rs.findColumn("genre");
			book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6),
					rs.getInt(7),rs.getInt(8),rs.getInt(10),rs.getString(9),rs.getString(indexOfAuthor), rs.getString(indexOfGenre));
			
		} catch (SQLException | InvalidInfoException e) {
			e.printStackTrace();
		}
		return book;
	}
     
	
	public Computer getComputerById(int id) {
		Computer computer = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement(GET_COMPUTER_BY_ID);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int indexOfoperationSystem = rs.findColumn("operation_system");
			int indexOfSSD = rs.findColumn("ssd");
			int indexOfRAM = rs.findColumn("ram");
			int indexOfProcessor = rs.findColumn("processor");
			computer = new Computer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6),
					rs.getInt(7),rs.getInt(8),rs.getInt(10),rs.getString(9),rs.getString(indexOfoperationSystem), rs.getInt(indexOfSSD),rs.getInt(indexOfRAM), rs.getString(indexOfProcessor));

		} catch (SQLException | InvalidInfoException e) {
			e.printStackTrace();
		}
		return computer;
	}
     
	@Override
	public List<Product> productBy(String selection, String input) {
		List<Product> products = new ArrayList<>();
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(getSearchParam(selection));
			ps.setString(1, "%" + input + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public String getSearchParam(String selection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getProductPriceById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
