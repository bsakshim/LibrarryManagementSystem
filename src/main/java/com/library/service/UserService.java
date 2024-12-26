package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.User;
import com.library.repository.UserRepository;
import com.library.security.CustomUserDetails;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	// Register a new user
    public User registerUser(User user) {
    	user.setRole("USER");
        return userRepository.save(user);
    }
    
    public User loginUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).orElse(null);
    }
    

    // Get user profile
    public User getUserProfile(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    
    // Update user profile
    public User updateUserProfile(Long userId, User userDetails) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(userDetails.getUsername());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null;
    }
    
    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public boolean authenticate(String username, String password) {
        // Retrieve user by username
        Optional<User> userOptional = userRepository.findByUsername(username);
        
        // Check if user exists and passwords match
        if (userOptional.isPresent()) {
            User user = userOptional.get();  // Extract the User object from Optional
            return user.getPassword().equals(password); // Compare passwords
        }
        
        return false; // Return false if user is not found
    }
    
    public Optional<CustomUserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(CustomUserDetails::new); // Wrap the User entity in a CustomUserDetails object
    }
}
