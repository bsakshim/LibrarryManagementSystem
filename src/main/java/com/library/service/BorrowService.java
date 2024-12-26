package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Borrow;
import com.library.repository.BorrowRepository;

@Service
public class BorrowService {
	@Autowired
	private BorrowRepository borrowRepository;

	// borrow book
	public Borrow borrowBook(Borrow borrow) {
		return borrowRepository.save(borrow);
	}

	// return a borrowed book
	public Borrow returnBook(Long id) {
		Borrow borrow = borrowRepository.findById(id).orElse(null);
		if (borrow != null) {
			borrow.setReturned(true);
			return borrowRepository.save(borrow);
		}
		return null;
	}

	// list of borrowed books by user
	public List<Borrow> getUserBorrowedBooks(Long userId) {
		return borrowRepository.findByUserId(userId);
	}

	public List<Borrow> getAllBorrowedBooks() {
		// TODO Auto-generated method stub
		return borrowRepository.findAll();
	}
}
