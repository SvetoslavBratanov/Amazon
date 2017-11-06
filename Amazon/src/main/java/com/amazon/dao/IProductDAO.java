package com.amazon.dao;

import java.sql.SQLException;
import java.util.List;

import com.amazon.model.Product;


public interface IProductDAO {
	
	List<Product> getAllProducts();
	void addProduct(Product product) throws SQLException;
	List<Product> productBy(String selection, String input);
	Product getProductById(int id);
	String getSearchParam(String selection);
	
}
