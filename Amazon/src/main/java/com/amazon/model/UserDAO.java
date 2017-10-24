package com.amazon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazon.connectionDB.DBConnection;

public class UserDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO users(user_name, email, password, isAdmin) VALUES (?, ?, md5(?), ?);";
	private static final String SELECT_USER_SQL = "SELECT id FROM users WHERE email = ? AND password = md5(?);";

	
	
	
	public void write(User user) {
		Connection connection = DBConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(user.getEmail());
		try {
			ps.setString(1, user.getName());

			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setBoolean(4, false);
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int loginUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next() == false) {
				throw new UserException("Wrong password or email!");
			}
			return rs.getInt(1);
		} catch (SQLException e) {
			throw new UserException("User cannot be logged right now.", e);
		}
	}

	public boolean checkEmail(String email) throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		String query = "SELECT email FROM users WHERE email ='" + email + "'";
		ResultSet rs = null;
		try (Statement stmt = connection.createStatement()) {
			rs = stmt.executeQuery(query);
			return rs.first();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}

	}
}
