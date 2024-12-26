package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	// get all books
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// add new book
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	// update an existing book
	public Book updateBook(Long id, Book bookDetails) {
		Optional<Book> existingBook = bookRepository.findById(id);
		if (existingBook.isPresent()) {
			Book book = existingBook.get();
			book.setTitle(bookDetails.getTitle());
			book.setAuthor(bookDetails.getAuthor());
			book.setPublishedDate(bookDetails.getPublishedDate());
			// Update other fields as necessary
			return bookRepository.save(book);
		}
		return null;
	}

	// delete book
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
