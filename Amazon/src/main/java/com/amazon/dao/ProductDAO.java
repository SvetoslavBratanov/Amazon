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

	private static final String GET_ALL_PRODUCTS = "SELECT * FROM products";
	private static final String INSERT_NEW_PRODUCT_QUERY = "INSERT INTO amazon.products"
			+ "(product_name, description, price, publish_date, quantity, times_sold, star_raiting, poster, category_id) "
			+ "VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?);";

	@Override
	public List<Product> getAllProducts() {
		Statement statement;
		List<Product> result = new ArrayList<Product>();
		try {
			statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery(GET_ALL_PRODUCTS);
			while (rs.next()) {
				Product product = new Product();
						result.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void addProduct(Product product) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT_NEW_PRODUCT_QUERY);

			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			//ps.setDate(4, product.getDate());
			ps.setInt(5,product.getQuantaty());
			ps.setInt(6, product.getTime_sold());
			ps.setInt(7,product.getRaiting());
			ps.setInt(8,product.getCategory_id());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public double getProductPriceById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> bookBy(String selection, String input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSearchParam(String selection) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
