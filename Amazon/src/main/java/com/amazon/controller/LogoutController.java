package com.amazon.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request,HttpServletResponse response) {
		System.out.println("GET LOGOUT");

        HttpSession session = request.getSession();
        if (session != null) {
        	session.removeAttribute("user");
            session.invalidate();
        }
        response.setHeader("Pragma", "No-cache");
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();

        if ( cookies != null ) for ( Cookie cookie : cookies ) {
            cookie.setValue("");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/index";	
	}
}
