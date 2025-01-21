package com.order.orderservice.service;

import com.order.orderservice.model.Order;
import com.order.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AuditService auditService;

    @Autowired
    private PartServiceClient partServiceClient;

    // This method will run every hour (can adjust the interval as needed)
    @Scheduled(cron = "0 0 * * * ?")  // Every hour, at the top of the hour
    public void checkAndPlaceOrders() {
        // Loop through all parts
        var parts = partServiceClient.getAllParts();
        for (var part : parts) {
            // Check if the stock is below threshold
            if (part.getAvailableQty() < part.getThresholdQty()) {
                // If Supplier-B, only place the order between 12:00 AM and 01:00 AM
                if (part.getSupplier().equalsIgnoreCase("Supplier-B") && isDiscountTime()) {
                    placeOrder(part);
                } else if (part.getSupplier().equalsIgnoreCase("Supplier-A")) {
                    placeOrder(part);
                }
            }
        }
    }

    public void checkAndCreateOrder(Long partId) {
        var part = partServiceClient.getPartById(partId);
        if (part != null && part.getAvailableQty() < part.getThresholdQty()) {
            placeOrder(part);
        }
    }

    // Method to check if the current time is between 12:00 AM and 01:00 AM
    private boolean isDiscountTime() {
        LocalTime currentTime = LocalTime.now();
        return currentTime.isAfter(LocalTime.MIDNIGHT) && currentTime.isBefore(LocalTime.MIDNIGHT.plusHours(1));
    }

    // Place an order based on the part details
    private void placeOrder(Part part) {
        Order order = new Order();
        order.setPartId(part.getId());
        order.setQuantity(part.getMinOrderQty());
        order.setSupplier(part.getSupplier());
        order.setOrderTime(LocalTime.now());
        orderRepository.save(order);

        // Log this order placement in the Audit Service (optional, but useful)
        // auditService.logAudit("Order Placed", "Order placed for part ID: " + part.getId());
    }
}