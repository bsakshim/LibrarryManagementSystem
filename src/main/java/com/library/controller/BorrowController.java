package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Borrow;
import com.library.service.BorrowService;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {
	@Autowired
	private BorrowService borrowService;

	// Borrow a book
	@PostMapping
	public ResponseEntity<Borrow> borrowBook(@RequestBody Borrow borrow) {
		Borrow newBorrow = borrowService.borrowBook(borrow);
		return ResponseEntity.ok(newBorrow);
	}

	// Return a book
	@PutMapping("/{id}/return")
	public ResponseEntity<String> returnBook(@PathVariable Long id) {
		borrowService.returnBook(id);
		return ResponseEntity.ok("Book returned successfully.");
	}

	// Get all borrowed books
	@GetMapping
	public ResponseEntity<List<Borrow>> getAllBorrowedBooks() {
		List<Borrow> borrowedBooks = borrowService.getAllBorrowedBooks();
		return ResponseEntity.ok(borrowedBooks);
	}
}
