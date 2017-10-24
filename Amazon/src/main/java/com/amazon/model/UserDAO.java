package com.amazon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazon.connectionDB.DBConnection;


public class UserDAO {

	private static final String INSERT_USER_SQL = "INSERT INTO users(user_name, email, password, isAdmin) VALUES (?, ?, md5(?), ?)";
	private static final String SELECT_USER_SQL = "SELECT id FROM users WHERE email = ? AND password = md5(?)";
	private static final String CHECK_USER_SQL = "SELECT count(1) FROM users WHERE email = ?";

	public int registerUser(User user) throws UserException {
		Connection connection = DBConnection.getInstance().getConnection();
			PreparedStatement ps;
			int count = -1;
			try {
				ps = connection.prepareStatement(CHECK_USER_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getEmail());
				ps.execute(CHECK_USER_SQL);
				ResultSet resultSet = ps.executeQuery();
				if(resultSet.next()) {
				    count = resultSet.getInt(1);
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		if(count == 0) {
			try {
				ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				ps.setBoolean(4, false);
				ps.executeUpdate();
	
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				return rs.getInt(1);
			} catch (SQLException e) {
				throw new UserException("User cannot be registered now, please try again later.", e);
			}
		} else {
			throw new UserException("You are already registered!");

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
}
