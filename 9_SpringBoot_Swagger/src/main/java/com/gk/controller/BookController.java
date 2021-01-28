package com.gk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk.model.Book;
import com.gk.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/book")
@Api(value = "Book Service", description = "My Book Store")//@ApiModel: It provides additional information about Swagger Controllers.
public class BookController {

	@Autowired
	private BookService service;

	@PostMapping("/save")
	@ApiOperation(value = "Store Book Api")//If we want to give meaning full name to method for rest api documentation
	public String saveBook(Book book) {
		return service.saveBook(book);
	}

	@GetMapping("/searchBook/{bookId}")
	@ApiOperation(value = "Search Book Api")
	public Optional<Book> getBook(@PathVariable int bookId) {
		return service.getBook(bookId);
	}

	@DeleteMapping("/deleteBook/{bookId}")
	public List<Book> deleteBook(@PathVariable int bookId) {
		return service.removeBook(bookId);
	}

}
