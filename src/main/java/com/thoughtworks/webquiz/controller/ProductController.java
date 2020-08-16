package com.thoughtworks.webquiz.controller;


import com.thoughtworks.webquiz.domain.Product;
import com.thoughtworks.webquiz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProductList() {
        List<Product> products =
                productRepository.findAll().stream()
                        .map(
                                productDto ->
                                        Product.builder()
                                                .name(productDto.getName())
                                                .price(productDto.getPrice())
                                                .unit(productDto.getUnit())
                                                .build())
                        .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

}
