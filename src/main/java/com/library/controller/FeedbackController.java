package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Feedback;
import com.library.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    
    @Autowired
    private FeedbackService feedbackService;

    // Submit feedback
    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Feedback feedback) {
        try {
            Feedback newFeedback = feedbackService.submitFeedback(feedback);
            return new ResponseEntity<>(newFeedback, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // In case of errors
        }
    }

    // Get all feedbacks (Admin or for listing)
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        try {
            List<Feedback> feedbackList = feedbackService.getAllFeedback();
            return ResponseEntity.ok(feedbackList);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get feedback by user ID (for a specific user)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Feedback>> getFeedbackByUserId(@PathVariable Long userId) {
        try {
            // Corrected method call here
            List<Feedback> feedbackList = feedbackService.getFeedbackByUserId(userId);
            return ResponseEntity.ok(feedbackList);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Handle user not found
        }
    }

    // Get feedback by feedback ID (for viewing specific feedback)
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        try {
            Feedback feedback = feedbackService.getFeedbackById(id);
            if (feedback != null) {
                return ResponseEntity.ok(feedback);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Feedback not found
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete feedback (for admin to delete specific feedback)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        try {
            feedbackService.deleteFeedback(id);
            return ResponseEntity.ok("Feedback deleted successfully.");
        } catch (Exception e) {
            return new ResponseEntity<>("Feedback not found or unable to delete.", HttpStatus.NOT_FOUND);
        }
    }
}
