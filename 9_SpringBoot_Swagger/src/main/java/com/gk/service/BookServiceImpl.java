package com.gk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.dao.BookRepository;
import com.gk.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;
	
	@Override
	public String saveBook(Book book) {
		repository.save(book);
		return "Book Ssaved with Id:"+book.getBookId();
	}

	@Override
	public Optional<Book> getBook(int bookId) {
		return repository.findById(bookId);
	}

	@Override
	public List<Book> removeBook(int bookId) {
		repository.deleteById(bookId);
		return repository.findAll();
	}

}
