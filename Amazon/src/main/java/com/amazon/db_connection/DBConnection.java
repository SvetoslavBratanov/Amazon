package com.amazon.db_connection;
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;

public class DBConnection {
	private Connection connection;
	private static DBConnection DBConnection;
	
	private static final String DB_HOSTNAME = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DATABASE = "amazon";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "1234";
	
	@Autowired
	private DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = 
					DriverManager.getConnection("jdbc:mysql://" + 
							DB_HOSTNAME + ":" + 
							DB_PORT + "/" + DATABASE+"?autoReconnect=true", 
							DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static DBConnection getInstance() {
		if (DBConnection == null) {
			DBConnection = new DBConnection();
		}
		return DBConnection;
	}

	public Connection getConnection() {
		return connection;
	}
}
