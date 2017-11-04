package com.amazon.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amazon.dao.UserDAO;
import com.amazon.exception.InvalidInfoException;
import com.amazon.exception.UserException;
import com.amazon.model.User;

@Controller
public class LoginController {

	private UserDAO userDAO;

	@Autowired
	public LoginController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginTemplate() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) throws InvalidInfoException {
		User user = new User();
		System.out.println("sdasfsadlkfmsdalkfcmsdlfcmdslfmdsdklfmcsmnfedfnsenfs");
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
			try {
				
				if(userDAO.checkUser(user)) {
					HttpSession session = request.getSession();
					session.setAttribute("user" , user);
					return "/index";
				}
			} catch (SQLException e) {
				request.setAttribute("errorMessage", "There is a problem with the database");
				return "/error";
			}
		request.setAttribute("errorMessage", "You have not been registered");
		return "/login";
	}

//	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
//	public ModelAndView registrationTemplate() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("registration");
//		return modelAndView;
//	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(HttpServletRequest request) {
		System.out.println("asdfasdf");
		User user = new User();
		try {
			user.setEmail(request.getParameter("email"));
			System.out.println("Email" +request.getParameter("email"));
			user.setName(request.getParameter("name"));
			System.out.println("Name" +request.getParameter("name"));

			user.setPassword(request.getParameter("password"));
			System.out.println("Pass" +request.getParameter("password"));

		} catch (InvalidInfoException e) {
			request.setAttribute("errorMessage", e.getMessage());
			System.err.println(e.getMessage());
            return "/login";
		}
		
		try {
			this.userDAO.addUser(user);
		} catch (UserException e) { 
            request.setAttribute("errorMessage", e.getMessage());
            return "/login";
		} catch (SQLException e) {
			System.out.println("ERRROORRRR");
			e.printStackTrace();
			 request.setAttribute("errorMessage", "There is a problem with the database");
			return "/error";
		}
		HttpSession session = request.getSession();
		session.setAttribute("user" , user);
		return "/index";
	
	}
}
