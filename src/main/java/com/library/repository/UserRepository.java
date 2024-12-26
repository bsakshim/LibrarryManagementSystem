package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// Query for login
    Optional<User> findByUsernameAndPassword(String username, String password);

    // Find by username
    Optional<User> findByUsername(String username);

	Optional<User> findByEmailAndPassword(String email, String password);
	
}
