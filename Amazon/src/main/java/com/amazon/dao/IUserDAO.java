package com.amazon.dao;

import java.sql.SQLException;

import com.amazon.exception.UserException;
import com.amazon.model.User;



public interface IUserDAO {

	public boolean addUser(User user) throws SQLException, UserException;
	public boolean checkEmail(String email) throws SQLException;
	public boolean checkUser(User user) throws SQLException;
	public void sendEmail(String email);

}