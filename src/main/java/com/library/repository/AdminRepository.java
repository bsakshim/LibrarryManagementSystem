package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.Admin;
import com.library.model.User;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByUserName(String username);
}
