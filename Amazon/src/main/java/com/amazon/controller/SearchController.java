package com.amazon.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

		try {
			from = Double.parseDouble((String) request.getParameter("from"));
			to = Double.parseDouble((String) request.getParameter("to"));
			products = searchDao.getProductByPrice(from, to);
			model.addAttribute("products", products);
		} catch (NumberFormatException e) {
			model.addAttribute("errorMessage", "Invalid input!");
			return "products";
		}
		if (products == null) {
			model.addAttribute("errorMessage", "There are no such products!");
		}
		return "products";
	}


	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooksByPrice(Model model, HttpServletRequest request) throws InvalidInfoException {
		List<Book> books = null;
		books = searchDao.getAllBooks();
		try {
			Double from = Double.parseDouble((String) request.getParameter("from"));
			Double to = Double.parseDouble((String) request.getParameter("to"));
			books = books.stream().filter(book -> (book.getPrice() > from) && book.getPrice() < to)
					.collect(Collectors.toList());
		} catch (NullPointerException ex) {
		
			model.addAttribute("books", books);
			return "books";
		}
		model.addAttribute("books", books);
		return "books";
	}

	

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String getMoviestByPrice(Model model, HttpServletRequest request) throws InvalidInfoException {
		List<Movie> movies = null;
		movies = searchDao.getAllMovies();
		try {
			Double from = Double.parseDouble((String) request.getParameter("from"));
			Double to = Double.parseDouble((String) request.getParameter("to"));
			movies = movies.stream().filter(movie -> (movie.getPrice() > from) && movie.getPrice() < to)
					.collect(Collectors.toList());
		} catch (NullPointerException ex) {
		
			model.addAttribute("movies", movies);
			return "movies";
		}
		model.addAttribute("movies", movies);
		return "movies";
	}
	


	@RequestMapping(value = "/computers", method = RequestMethod.GET)
	public String getComputersByPrice(Model model, HttpServletRequest request) throws InvalidInfoException {
		List<Computer> computers = null;
		computers = searchDao.getAllComputers();
		try {
			Double from = Double.parseDouble((String) request.getParameter("from"));
			Double to = Double.parseDouble((String) request.getParameter("to"));
			computers = computers.stream().filter(computer -> (computer.getPrice() > from) && computer.getPrice() < to)
					.collect(Collectors.toList());
		} catch (NullPointerException ex) {
		
			model.addAttribute("computers", computers);
			return "computers";
		}
		model.addAttribute("computers", computers);
		return "computers";
	}

}