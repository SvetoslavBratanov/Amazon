package com.amazon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazon.exception.AuthorException;
import com.amazon.exception.ProductException;
import com.amazon.model.Book;
import com.amazon.model.Product;

public class ProductDAO extends AbstractDAO implements IProductDAO {

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getProductPriceById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> productBy(String selection, String input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSearchParam(String selection) {
		// TODO Auto-generated method stub
		return null;
	}

//	private static final String GET_ALL_PRODUCTS = "SELECT * FROM products";
//	private static final String INSERT_NEW_PRODUCT_QUERY = "INSERT INTO amazon.products"
//			+ "(product_name, description, price, publish_date, quantity, times_sold, star_raiting, poster, category_id) "
//			+ "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?);";
//	private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM amazon.products WHERE id = ?;";
//
//	@Override
//	public List<Product> getAllProducts() {
//		Statement statement;
//		List<Product> result = new ArrayList<Product>();
//		try {
//			statement = getConnection().createStatement();
//			ResultSet rs = statement.executeQuery(GET_ALL_PRODUCTS);
//			while (rs.next()) {
////				Product product = new Product();
////				result.add(product);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	@Override
//	public void addProduct(Product product) {
//		try {
//			PreparedStatement ps = getConnection().prepareStatement(INSERT_NEW_PRODUCT_QUERY);
//
//			ps.setString(1, product.getName());
//			ps.setString(2, product.getDescription());
//			ps.setDouble(3, product.getPrice());
//			//ps.setDate(4, product.getDate());
//			ps.setInt(5,product.getQuantaty());
//			//ps.setInt(6, product.getTime_sold());
//			ps.setInt(7,product.getRaiting());
//			ps.setInt(8,product.getCategory_id());
//
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//	@Override
//	public double getProductPriceById(int id) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public List<Product> productBy(String selection, String input) {
//		List<Product> products = new ArrayList<>();
//		
//		try {
//			PreparedStatement ps = getConnection().prepareStatement(getSearchParam(selection));
//			ps.setString(1, "%" + input + "%");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
////				Product product = new Product();
////				products.add(product);
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//
//		return products;
//	}
//
//	@Override
//	public Product getProductById(int id) {
//		Product product = null;
//		
//		try {
//			PreparedStatement ps = getConnection().prepareStatement(GET_PRODUCT_BY_ID_QUERY);
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			rs.next();
//			product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5), rs.getInt(6),
//					rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10));
//					
//			
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		
//		return product;
//	}
//
//	@Override
//	public String getSearchParam(String selection) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
