package com.jiyad.service;

import com.jiyad.model.PG;
import com.jiyad.repository.PGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PGService {
    
    @Autowired
    private PGRepository pgRepository;
    
    // Get all PGs
    public List<PG> getAllPGs() {
        return pgRepository.findAll();
    }
    
    // Get PG by ID
    public Optional<PG> getPGById(Long id) {
        return pgRepository.findById(id);
    }
    
    // Save new PG
    public PG savePG(PG pg) {
        return pgRepository.save(pg);
    }
    
    // Update existing PG
    
    public PG updatePG(Long id, PG pgDetails) {
        Optional<PG> optionalPG = pgRepository.findById(id); //original
    	
        if (optionalPG.isPresent()) {
            PG pg = optionalPG.get();

            // Required fields (nullable = false)
            if (pgDetails.getName() != null) pg.setName(pgDetails.getName());
            if (pgDetails.getOwnerName() != null) pg.setOwnerName(pgDetails.getOwnerName());
            if (pgDetails.getContactNumber() != null) pg.setContactNumber(pgDetails.getContactNumber());
            if (pgDetails.getAddress() != null) pg.setAddress(pgDetails.getAddress());
            if (pgDetails.getRentSingle() != null) pg.setRentSingle(pgDetails.getRentSingle());
            if (pgDetails.getRentDouble() != null) pg.setRentDouble(pgDetails.getRentDouble());
            if (pgDetails.getFoodProvided() != null) pg.setFoodProvided(pgDetails.getFoodProvided());
            if (pgDetails.getWifiAvailable() != null) pg.setWifiAvailable(pgDetails.getWifiAvailable());
            if (pgDetails.getAcAvailable() != null) pg.setAcAvailable(pgDetails.getAcAvailable());

            // Optional fields (nullable = true)
            if (pgDetails.getAlternateContact() != null) pg.setAlternateContact(pgDetails.getAlternateContact());
            if (pgDetails.getLandmark() != null) pg.setLandmark(pgDetails.getLandmark());
            if (pgDetails.getRentTriple() != null) pg.setRentTriple(pgDetails.getRentTriple());

            // Save and return updated PG
            return pgRepository.save(pg);
        }
        return null;
    }

    // Delete PG
    public boolean deletePG(Long id) {
        if (pgRepository.existsById(id)) {
            pgRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    // Search PGs by location
    public List<PG> searchPGsByLocation(String location) {
        return pgRepository.findByAddressContainingIgnoreCase(location);
    }
    
    // Filter PGs by rent range
    public List<PG> filterPGsByRent(BigDecimal minRent, BigDecimal maxRent) {
        return pgRepository.findByRentRange(minRent, maxRent);
    }
}
