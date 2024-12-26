package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Admin;
import com.library.model.User;
import com.library.repository.AdminRepository;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;

@Service
public class AdminService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
    private AdminRepository adminRepository;
	
	// get list of all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// to add new user
	public User addUSer(User user) {
		return userRepository.save(user);
	}

	// update user details
	public User updateUser(Long id, User userDetails) {
		Optional<User> existingUser = userRepository.findById(id);
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

	public void deleteUSer(Long id) {
		userRepository.deleteById(id);
	}

	// Generate reports for admins (e.g., total books, total users)
	public String generateReports() {
		long totalBooks = bookRepository.count();
		long totalUsers = userRepository.count();
		long totalFines = 0;

		// Creating a simple report (You can customize this as per your needs)
		StringBuilder report = new StringBuilder();
		report.append("Library Report:\n").append("Total Books: ").append(totalBooks).append("\n")
				.append("Total Users: ").append(totalUsers).append("\n").append("Total Fines: ").append(totalFines)
				.append("\n");
		return report.toString();
	}
	
	public Admin createAdmin(Admin admin) {
        admin.setRole("ADMIN"); // Set the default role as ADMIN
        return adminRepository.save(admin);
    }

    public Admin findAdminByUsername(String username) {
        return adminRepository.findByUserName(username);
    }
}
