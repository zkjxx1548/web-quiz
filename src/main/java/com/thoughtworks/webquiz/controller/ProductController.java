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

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProductList() {
        ProductDto productDto1 =
                ProductDto.builder()
                        .name("可乐1")
                        .price(1)
                        .unit("瓶")
                        .build();
        ProductDto productDto2 =
                ProductDto.builder()
                        .name("可乐2")
                        .price(1)
                        .unit("瓶")
                        .build();
        ProductDto productDto3 =
                ProductDto.builder()
                        .name("可乐3")
                        .price(1)
                        .unit("瓶")
                        .build();
        ProductDto productDto4 =
                ProductDto.builder()
                        .name("可乐4")
                        .price(1)
                        .unit("瓶")
                        .build();
        ProductDto productDto5 =
                ProductDto.builder()
                        .name("可乐5")
                        .price(1)
                        .unit("瓶")
                        .build();
        ProductDto productDto6 =
                ProductDto.builder()
                        .name("可乐6")
                        .price(1)
                        .unit("瓶")
                        .build();
        productRepository.save(productDto1);
        productRepository.save(productDto2);
        productRepository.save(productDto3);
        productRepository.save(productDto4);
        productRepository.save(productDto5);
        productRepository.save(productDto6);

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
