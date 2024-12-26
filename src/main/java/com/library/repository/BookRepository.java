package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.Book;
import com.library.model.User;

public interface BookRepository extends JpaRepository<Book, Long> {
	 // Find books by title or author
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Custom query for available books
    List<Book> findByAvailable(boolean available);
}
