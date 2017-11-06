package com.amazon.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amazon.dao.SearchDao;
import com.amazon.exception.InvalidInfoException;
import com.amazon.model.Book;
import com.amazon.model.Computer;
import com.amazon.model.Movie;
import com.amazon.model.Product;

@Controller
public class SearchController {
	
	private SearchDao searchDao;

	@Autowired
	public SearchController(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	@RequestMapping(value = "/movielist", method = RequestMethod.GET)
	public List<Movie> getAllMovies() throws SQLException {
		try {
			return searchDao.getAllMovies();
		} catch (InvalidInfoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//
	//// @RequestMapping(value = "/books/{page}", method = RequestMethod.GET)
	//// public List<Book> getAllBooks(@PathVariable(name="page")int page, String
	// pattern){
	//// return searchDao.getAllBooks().subList((page -1)*pageSize, page*pageSize);
	//// }

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getAllBooks(Model model) throws InvalidInfoException, SQLException {
		List<Book> books = searchDao.getAllBooks();
		model.addAttribute("products", books);
		return "products";
	}

	@RequestMapping(value = "/computers", method = RequestMethod.GET)
	public String getAllComputers(Model model) {
		List<Computer> computers = searchDao.getAllComputers();
		model.addAttribute("products", computers);
		return "products";
	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String getAllMovies(ModelMap model) throws SQLException {
		List<Movie> movies = null;
		try {
			movies = searchDao.getAllMovies();
		} catch (InvalidInfoException e) {
			e.printStackTrace();
		}
		model.put("products", movies);
		return "products";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getAllProducts(Model model, HttpServletRequest request) {
		String s = request.getParameter("input");
		List<Product> products = searchDao.getProductByName(s);
		model.addAttribute("products", products);
		return "products";
	}
	
	@RequestMapping(value = "/productsByPrice", method = RequestMethod.GET)
	public String getProductByPrice(Model model, HttpServletRequest request) {
		double from = 0;
		double to = 0;
		List<Product> products = null;

		if(request.getParameter("from") != null|| request.getParameter("to") != null) {
			from = Double.parseDouble((String) request.getParameter("from"));
			to = Double.parseDouble((String) request.getParameter("to"));
			products = searchDao.getProductByPrice(from, to);
			model.addAttribute("products", products);
		} else {
			model.addAttribute("errorMessage","Invalid input!");
		}
		if(products == null) {
			model.addAttribute("errorMessage","There are no such products!");
		}
		return "products";
	}

}