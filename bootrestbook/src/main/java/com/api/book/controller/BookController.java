package com.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

//	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@GetMapping(value = "/books")
	public List<Book> getBooks() {
		/*
		 * Book book = new Book(); book.setId(1); book.setTitle("Java notes");
		 * book.setAuthor("yash");
		 */

		System.out.println("this is getbooks on console ");
		return (List<Book>) this.bookService.getAllBooks();
	}

	@GetMapping(value = "/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return this.bookService.getBookById(id);
	}

	@PostMapping(value = "/books")
	public Book addBook(@RequestBody Book book) {
		Book book2 = this.bookService.addBook(book);
		System.out.println(book2);
		return book2;
	}

}