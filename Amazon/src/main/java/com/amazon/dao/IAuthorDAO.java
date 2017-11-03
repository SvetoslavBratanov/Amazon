package com.amazon.dao;

import java.util.List;

import com.amazon.exception.AuthorException;
import com.amazon.model.Author;



public interface IAuthorDAO {

	List<Author> getAllAuthors();

	int getAuthorId(String name);

	Author getAuthorById(int id) throws AuthorException;

	int addAuthor(Author author);

}