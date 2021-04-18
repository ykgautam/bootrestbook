package com.api.book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;

//@Service
@Component
public class BookService {

	private static List<Book> bookList = new ArrayList<Book>();

	static {
		bookList.add(new Book(2, "spring reference", "ankit"));
		bookList.add(new Book(1, "java reference", "yash"));
		bookList.add(new Book(23, "head first to java", "omkar"));
	}

	public List<Book> getAllBooks() {
		return bookList;
	}

	public Book getBookById(int id) {
//		using stream api to get single book wrt id
		Book book = null;
		book = bookList.stream().filter(e -> e.getId() == id).findFirst().get();
		System.out.println("get single book " + book);
		return book;
	}

//	adding the book info
	public Book addBook(Book b) {
		bookList.add(b);
		return b;
	}

}
