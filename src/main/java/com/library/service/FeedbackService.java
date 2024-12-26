package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Feedback;
import com.library.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Submit feedback
    public Feedback submitFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Get all feedback (for admin)
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // Get feedback by user ID
    public List<Feedback> getFeedbackByUserId(Long userId) {
        return feedbackRepository.findByUserId(userId);
    }

    // Get feedback by ID (returns a single Feedback object instead of a list)
    public Feedback getFeedbackById(Long id) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);
        return feedbackOptional.orElse(null);  // Return feedback or null if not found
    }

    // Resolve feedback (mark as resolved)
    public Feedback resolveFeedback(Long id) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);
        if (feedbackOptional.isPresent()) {
            Feedback feedback = feedbackOptional.get();
            feedback.setResolved(true);  // Assuming 'resolved' is a field in Feedback
            return feedbackRepository.save(feedback);  // Save the resolved feedback
        }
        return null; // Handle feedback not found
    }

    // Delete feedback by ID
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
