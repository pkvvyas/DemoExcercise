package com.order.orderservice.controller;

import com.order.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/checkAndCreate/{partId}")
    public void checkAndCreateOrder(@PathVariable Long partId) {
        orderService.checkAndCreateOrder(partId);
    }
}