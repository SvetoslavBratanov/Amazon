package com.amazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String homeTemplate() {
		return "index";
	}
	
	
	@RequestMapping(value = {"/mail"}, method = RequestMethod.GET)
	public ModelAndView mailTemplate() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mail");
		return modelAndView;
	}
	
	@RequestMapping(value = {"/about"}, method = RequestMethod.GET)
	public ModelAndView aboutTemplate() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about");
		return modelAndView;
	}
	
}
