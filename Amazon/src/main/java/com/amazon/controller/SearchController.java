package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.dao.SearchDao;
import com.amazon.model.Book;
import com.amazon.model.Computer;
import com.amazon.model.Movie;

@RestController
public class SearchController {
	//int pageSize = 10;
	private SearchDao searchDao;
	
	@Autowired
	public  SearchController(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	
	@RequestMapping(value = "/movielist", method = RequestMethod.GET)
	public List<Movie> getAllMovies(){
		return searchDao.getAllMovies();
	}
//	
////	@RequestMapping(value = "/books/{page}", method = RequestMethod.GET)
////	public List<Book> getAllBooks(@PathVariable(name="page")int page, String pattern){
////		return searchDao.getAllBooks().subList((page -1)*pageSize, page*pageSize);
////	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getAllBooks(){
		return searchDao.getAllBooks();
	}
	

	@RequestMapping(value = "/computers", method = RequestMethod.GET)
	public List<Computer> getAllComputers(){
		return searchDao.getAllComputers();
	}
	
	
}
