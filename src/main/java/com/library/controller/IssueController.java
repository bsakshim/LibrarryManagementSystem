package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Issue;
import com.library.service.IssueService;

@RestController
@RequestMapping("/api/issues")
public class IssueController {
	  @Autowired
	    private IssueService issueService;

	    // Issue a book to a user
	    @PostMapping
	    public ResponseEntity<Issue> issueBook(@RequestBody Issue issue) {
	        Issue newIssue = issueService.issueBook(issue);
	        return ResponseEntity.ok(newIssue);
	    }

	    // Get all issued books
	    @GetMapping
	    public ResponseEntity<List<Issue>> getAllIssuedBooks() {
	        List<Issue> issuedBooks = issueService.getAllIssuedBooks();
	        return ResponseEntity.ok(issuedBooks);
	    }
}
