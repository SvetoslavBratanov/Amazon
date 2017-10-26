package com.amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.amazon.db_connection.DBConnection;
import com.amazon.model.User;

@Service
public class UserDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO users(user_name, email, password, isAdmin) VALUES (?, ?, md5(?), ?);";

	public boolean write(User user) {

		try {
			if (checkEmail(user.getEmail())) {
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		Connection connection = DBConnection.getInstance().getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		return true;
	}

	public String loginUser(User user) {
		try {
			if(checkUser(user)){
				return "home";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "login";
	}

	private boolean checkEmail(String email) throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		String query = "SELECT email  FROM users WHERE email ='" + email + "'";
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

	private boolean checkUser(User user) throws SQLException {
		Connection connection = DBConnection.getInstance().getConnection();
		String query = "SELECT email ,password FROM users WHERE email ='" + user.getEmail() + "' and password =MD5('"
				+ user.getPassword() + "');";
		ResultSet rs = null;
		try (Statement stmt = connection.createStatement()) {
			rs = stmt.executeQuery(query);
			return rs.next();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
	}
}
