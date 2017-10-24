package com.amazon.controller;

import java.io.IOException;
import java.sql.SQLException;

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
		resp.getWriter().println(name + " " + password);
		UserDAO us = new UserDAO();
		User u = new User(name, password, email);

		try {
			if (!us.checkEmail(u.getEmail())) {
				us.write(u);
			} else {
			resp.sendError(HttpServletResponse.SC_CONFLICT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
