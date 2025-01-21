package com.part.partservice.service;

import com.part.partservice.model.Part;
import com.part.partservice.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;

    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    public Optional<Part> getPartById(Long id) {
        return partRepository.findById(id);
    }

    public Part addPart(Part part) {
        return partRepository.save(part);
    }

    public Part updatePart(Part part) {
        return partRepository.save(part);
    }

    public void updateQty(Long partId, int qty) {
        Optional<Part> partOpt = partRepository.findById(partId);
        partOpt.ifPresent(part -> {
            part.setAvailableQty(qty);
            partRepository.save(part);
        });
    }
}