package com.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

//	get single book handler
//	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@GetMapping(value = "/books")
	public List<Book> getBooks() {

		System.out.println("this is getbooks on console ");
		return (List<Book>) this.bookService.getAllBooks();
	}

//	get single book handler
	@GetMapping(value = "/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return this.bookService.getBookById(id);
	}

//	add single book handler
	@PostMapping(value = "/books")
	public Book addBook(@RequestBody Book book) {
		Book newBook = this.bookService.addBook(book);
		System.out.println(newBook);
		return newBook;
	}

//	delete single book handler
	@DeleteMapping(value = "books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.bookService.deleteBook(id);
	}

//	update book handler
	@PutMapping(value = "/books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		this.bookService.updateBook(book, id);
		return book;
	}

}
