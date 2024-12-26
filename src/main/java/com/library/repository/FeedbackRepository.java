package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
	// Find feedback by user
    List<Feedback> findByUserId(Long userId);

    // Custom query for unresolved feedback
    List<Feedback> findByResolvedFalse();
}
