package com.api.book.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

//@Service
@Component
public class BookService {
	/*
	 * private static List<Book> bookList = new ArrayList<Book>(); static {
	 * bookList.add(new Book(2, "spring reference", "ankit")); bookList.add(new
	 * Book(1, "java reference", "yash")); bookList.add(new Book(23,
	 * "head first to java", "omkar")); }
	 */
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	public Book getBookById(int id) {
//		using stream api to get single book wrt id
		Book book = null;
		try {
//			book = bookList.stream().filter(e -> e.getId() == id).findFirst().get();
			book = this.bookRepository.findById(id);
		} catch (NoSuchElementException e2) {
			System.out.println("book id not matched..........");
			e2.printStackTrace();
		}
		return book;
	}

//	adding the book info
	public Book addBook(Book b) {
//		bookList.add(b);
		Book result = this.bookRepository.save(b);
		return result;
	}

//	delete a single book
	public void deleteBook(int id) {
//		bookList = bookList.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
		this.bookRepository.deleteById(id);
	}

//	update book
	public void updateBook(Book book, int id) {
		/*
		 * bookList.stream().map(b -> { if (b.getId() == id) {
		 * b.setTitle(book.getTitle()); b.setAuthor(book.getAuthor()); } return b;
		 * }).collect(Collectors.toList());
		 */
		book.setId(id);
		this.bookRepository.save(book);
	}

}
