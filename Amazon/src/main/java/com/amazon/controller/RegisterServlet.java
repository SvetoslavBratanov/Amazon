package com.amazon.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.model.User;
import com.amazon.model.UserDAO;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		try {
			
			new UserDAO().registerUser(new User(name, email, password));
		} catch (Exception e) {
			System.out.println("");
		}
	}
	


}

