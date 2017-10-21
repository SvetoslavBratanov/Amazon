package com.amazon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazon.connectionDB.DBConnection;



public class ProductDAO {
	private static final String INSERT_USER_SQL = "INSERT INTO products VALUES (null, ?, ?, ?, ?, ?, ?,?)";
	private static final String SELECT_USER_SQL = "SELECT id FROM products WHERE product_name = ? AND quantaty > ?";
	
	public void addProduct(Product product, int quantaty) throws ProductException{

		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setTimestamp(4,java.sql.Timestamp.valueOf( product.getDate()));
			ps.setInt(5, product.getQuantaty());
			ps.setInt(6, product.getCategory_id());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
		} catch (SQLException e) {
			throw new ProductException("Product cannot be added now, please try again later.", e);
		}
	}
	
	public void buyProduct(Product product){
		Connection connection = DBConnection.getInstance().getConnection();
       //
	}
	
}
