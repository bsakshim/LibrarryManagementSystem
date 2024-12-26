package com.library.controller;

import com.library.model.User;
import com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // Show login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Handle login form submission
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        // Handle authentication logic here
        if (userService.authenticate(username, password)) {
            return "redirect:/user/dashboard";  // Redirect to user dashboard if authentication is successful
        } else {
            return "login";  // Show login page if credentials are incorrect
        }
    }

    // Show registration page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password,
                               @RequestParam String firstName, @RequestParam String lastName) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);  // Make sure to hash the password in real applications
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        userService.registerUser(newUser);
        return "redirect:/login";  // Redirect to login page after successful registration
    }

    // Handle logout
    @GetMapping("/logout")
    public String logoutPage() {
        // Handle session invalidation or logout logic here
        return "logout";  // Redirect to logout page
    }
}
