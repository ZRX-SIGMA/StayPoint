package com.jiyad.controller;

import com.jiyad.model.PG;
import com.jiyad.service.PGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pgs")
@CrossOrigin(origins = "http://localhost:3000") // Allow React app to connect
public class PGController {
    
    @Autowired
    private PGService pgService;
    
    // GET all PGs
    @GetMapping
    public ResponseEntity<List<PG>> getAllPGs() {
        List<PG> pgs = pgService.getAllPGs();
        return ResponseEntity.ok(pgs);
    }
    
    // GET PG by ID
    @GetMapping("/{id}")
    public ResponseEntity<PG> getPGById(@PathVariable Long id) {
        Optional<PG> pg = pgService.getPGById(id);
        if (pg.isPresent()) {
            return ResponseEntity.ok(pg.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    // POST create new PG
    @PostMapping
    public ResponseEntity<PG> createPG(@RequestBody PG pg) {
        try {
            PG savedPG = pgService.savePG(pg);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPG);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    // PUT update existing PG
    @PutMapping("/{id}")
    public ResponseEntity<PG> updatePG(@PathVariable Long id, @RequestBody PG pgDetails) {
        PG updatedPG = pgService.updatePG(id, pgDetails);
        if (updatedPG != null) {
            return ResponseEntity.ok(updatedPG);
        }
        return ResponseEntity.notFound().build();
    }
    
    // DELETE PG
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePG(@PathVariable Long id) {
        boolean deleted = pgService.deletePG(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // GET search PGs by location
    @GetMapping("/search")
    public ResponseEntity<List<PG>> searchPGs(@RequestParam String location) {
        List<PG> pgs = pgService.searchPGsByLocation(location);
        return ResponseEntity.ok(pgs);
    }
    
    // GET filter PGs by rent range
    @GetMapping("/filter")
    public ResponseEntity<List<PG>> filterPGs(
            @RequestParam BigDecimal minRent,
            @RequestParam BigDecimal maxRent) {
        List<PG> pgs = pgService.filterPGsByRent(minRent, maxRent);
        return ResponseEntity.ok(pgs);
    }
}
