package com.amazon.dao;


import java.sql.Connection;

import com.amazon.db_connection.DBConnection;

public abstract class AbstractDAO {
	
	private Connection connection;
	
	public AbstractDAO() {
		this.connection = DBConnection.getInstance().getConnection();
	}
	
	public Connection getConnection() {
		return this.connection;
	}

}
