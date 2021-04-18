package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
		try {
			book = bookList.stream().filter(e -> e.getId() == id).findFirst().get();

		} catch (NoSuchElementException e2) {
			System.out.println("book id not matched..........");
			e2.printStackTrace();
		}
		return book;
	}

//	adding the book info
	public Book addBook(Book b) {
		bookList.add(b);
		return b;
	}

//	delete a single book
	public void deleteBook(int id) {
		bookList = bookList.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
	}

//	update book
	public void updateBook(Book book, int id) {
		bookList.stream().map(b -> {
			if (b.getId() == id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}

}
