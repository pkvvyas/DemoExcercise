package com.order.orderservice.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "part-service")  // Name of the microservice to call
public interface PartServiceClient {

    @GetMapping("/api/parts/{id}")  // Endpoint to get part by ID
    Part getPartById(@PathVariable("id") Long id);

    @GetMapping("/api/parts")  // Endpoint to get all parts
    List<Part> getAllParts();
}
