package com.gk.service;

import java.util.List;
import java.util.Optional;

import com.gk.model.Book;

public interface BookService {

	public String saveBook(Book book);
	
	public Optional<Book> getBook(int bookId);
	
	public List<Book> removeBook(int bookId);
}
