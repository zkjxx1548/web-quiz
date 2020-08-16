package com.thoughtworks.webquiz.controller;


import com.thoughtworks.webquiz.domain.Product;
import com.thoughtworks.webquiz.dto.OrderDto;
import com.thoughtworks.webquiz.dto.ProductDto;
import com.thoughtworks.webquiz.repository.OrderRepository;
import com.thoughtworks.webquiz.repository.ProductRepository;
import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;


//    public static void init() {
//
//        new ProductRepository().save(ProductDto.builder().name("可乐1").price(1).unit("瓶").build());
//    }

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

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> addProductToOrder(@PathVariable int id) {
        ProductDto productDto = productRepository.findById(id).get();

        OrderDto orderDto = OrderDto.builder()
                .name(productDto.getName())
                .productId(id)
                .price(productDto.getPrice())
                .unit(productDto.getUnit())
                .count(1)
                .build();

        orderRepository.save(orderDto);

        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .unit(productDto.getUnit())
                .url(productDto.getUrl())
                .build();
        return ResponseEntity.ok(product);

    }
}
