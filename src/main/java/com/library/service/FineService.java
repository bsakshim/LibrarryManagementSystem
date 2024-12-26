package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Fine;
import com.library.repository.FineRepository;

@Service
public class FineService {
	@Autowired
	private FineRepository fineRepository;

	// Get all fines
	public List<Fine> getAllFines() {
		return fineRepository.findAll();
	}

	// Get fines for a specific user
	public List<Fine> getUserFines(Long userId) {
		return fineRepository.findByUserId(userId);
	}

	public Fine payFine(Long id) {
		Fine fine = fineRepository.findById(id).orElse(null);
		if (fine != null) {
			fine.setPaid(true);
			return fineRepository.save(fine);
		}
		return null;
	}
}
