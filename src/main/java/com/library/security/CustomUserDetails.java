package com.library.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.library.model.User;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private User user;

    // Constructor to initialize with User entity
    public CustomUserDetails(User user) {
        this.user = user;
    }

    // Get the authorities/roles associated with the user
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Create a list of granted authorities (roles)
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }

    // Get the password from the User entity
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // Get the username from the User entity
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // Account status checks
    @Override
    public boolean isAccountNonExpired() {
        return true;  // Assume account is always non-expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Assume account is always non-locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Assume credentials are never expired
    }

    @Override
    public boolean isEnabled() {
        return true;  // Assume user is always enabled
    }

    // Get the underlying User entity
    public User getUser() {
        return user;
    }
}
