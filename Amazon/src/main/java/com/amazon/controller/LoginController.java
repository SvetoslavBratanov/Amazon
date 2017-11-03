package com.amazon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amazon.dao.UserDAO;
import com.amazon.exception.InvalidInfoException;
import com.amazon.model.User;

@Controller
public class LoginController {

	private UserDAO userDAO;

	
	public LoginController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginTemplate() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, HttpServletRequest request) throws InvalidInfoException {
		User user = new User();
		System.out.println("sdasfsadlkfmsdalkfcmsdlfcmdslfmdsdklfmcsmnfedfnsenfs");
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		model.addAttribute("error", "Invalid username or password!");

		return null;
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public ModelAndView registrationTemplate() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(HttpServletRequest request) {
		System.out.println("asdfasdf");
		User user = new User();
		try {
			user.setEmail(request.getParameter("email"));
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
		} catch (InvalidInfoException e) {
			return "index";
		}
		if (!this.userDAO.addUser(user)) {
			return "index";
		}
		return "index";
	}
}
