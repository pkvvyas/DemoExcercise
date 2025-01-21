package com.part.partservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int availableQty;
    private int thresholdQty;
    private int minOrderQty;
    private String supplier;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public int getThresholdQty() {
        return thresholdQty;
    }

    public void setThresholdQty(int thresholdQty) {
        this.thresholdQty = thresholdQty;
    }

    public int getMinOrderQty() {
        return minOrderQty;
    }

    public void setMinOrderQty(int minOrderQty) {
        this.minOrderQty = minOrderQty;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
