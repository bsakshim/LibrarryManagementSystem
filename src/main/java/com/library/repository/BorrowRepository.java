package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.Book;
import com.library.model.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
	 // Get borrowed books by user ID
    List<Borrow> findByUserId(Long userId);

    // Get all currently borrowed (not returned) books
    List<Borrow> findByReturnedFalse();
}
