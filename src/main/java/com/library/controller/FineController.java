package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Fine;
import com.library.service.FineService;

@RestController
@RequestMapping("/api/fines")
public class FineController {
	@Autowired
    private FineService fineService;
	
	// Get all fines
    @GetMapping
    public ResponseEntity<List<Fine>> getAllFines() {
        List<Fine> fines = fineService.getAllFines();
        return ResponseEntity.ok(fines);
    }

    // Pay a fine
    @PutMapping("/{id}/pay")
    public ResponseEntity<String> payFine(@PathVariable Long id) {
        fineService.payFine(id);
        return ResponseEntity.ok("Fine paid successfully.");
    }
}
