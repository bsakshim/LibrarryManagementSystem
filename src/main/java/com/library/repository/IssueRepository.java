package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.Borrow;
import com.library.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
	// Query for all issued books
    List<Issue> findByReturnedFalse();

    // Find issued books for a specific user
    List<Issue> findByUserIdAndReturnedFalse(Long userId);

	List<Issue> findByUserId(Long userId);
}
