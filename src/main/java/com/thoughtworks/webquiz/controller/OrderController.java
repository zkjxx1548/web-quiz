package com.thoughtworks.webquiz.controller;

import com.thoughtworks.webquiz.domain.Order;
import com.thoughtworks.webquiz.domain.Product;
import com.thoughtworks.webquiz.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getProductList() {
        List<Order> orders = orderRepository.findAll().stream()
                .map(orderDto ->
                        Order.builder()
                                .name(orderDto.getName())
                                .productId(orderDto.getProductId())
                                .count(orderDto.getCount())
                                .price(orderDto.getPrice())
                                .unit(orderDto.getUnit())
                                .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(orders);
    }
}
