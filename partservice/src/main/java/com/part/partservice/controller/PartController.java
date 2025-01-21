package com.part.partservice.controller;

import com.part.partservice.model.Part;
import com.part.partservice.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parts")
public class PartController {

    @Autowired
    private PartService partService;

    @GetMapping
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }

    @GetMapping("/{id}")
    public Optional<Part> getPartById(@PathVariable Long id) {
        return partService.getPartById(id);
    }

    @PostMapping
    public Part addPart(@RequestBody Part part) {
        return partService.addPart(part);
    }

    @PutMapping("/{id}")
    public Part updatePart(@PathVariable Long id, @RequestBody Part part) {
        return partService.updatePart(part);
    }

    @PatchMapping("/{id}/updateQty")
    public void updateQty(@PathVariable Long id, @RequestParam int qty) {
        partService.updateQty(id, qty);
    }
}
