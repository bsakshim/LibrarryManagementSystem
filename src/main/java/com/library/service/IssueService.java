package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Borrow;
import com.library.model.Issue;
import com.library.repository.BorrowRepository;
import com.library.repository.IssueRepository;

@Service
public class IssueService {
	@Autowired
	private IssueRepository issueRepository;

	// Issue a book to a user
	public Issue issueBook(Issue issue) {
		return issueRepository.save(issue);
	}

	// Get list of all issued books
	public List<Issue> getAllIssuedBooks() {
		return issueRepository.findAll();
	}

	// Get issued books for a specific user
	public List<Issue> getUserIssuedBooks(Long userId) {
		return issueRepository.findByUserId(userId);
	}
}
