package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.Fine;

public interface FineRepository extends JpaRepository<Fine, Long> {
	 // Get fines for a specific user
    List<Fine> findByUserId(Long userId);

    // Get unpaid fines
    List<Fine> findByPaidFalse();
}
