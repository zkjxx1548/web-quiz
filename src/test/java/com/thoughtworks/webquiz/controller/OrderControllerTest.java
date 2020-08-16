package com.thoughtworks.webquiz.controller;

import com.thoughtworks.webquiz.domain.Order;
import com.thoughtworks.webquiz.dto.OrderDto;
import com.thoughtworks.webquiz.dto.ProductDto;
import com.thoughtworks.webquiz.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setUp() {

    }

    @Test
    void should_return_orders_list_when_get() throws Exception {
        OrderDto orderDto1 =
                OrderDto.builder()
                        .name("可乐1")
                        .productId(1)
                        .count(1)
                        .price(1)
                        .unit("瓶")
                        .build();


        orderRepository.save(orderDto1);
        mockMvc.perform(get("/order"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("可乐1")))
                .andExpect(jsonPath("$[0].price", is(1)))
                .andExpect(jsonPath("$[0].unit", is("瓶")))
                .andExpect(jsonPath("$[0].count", is(1)))
                .andExpect(jsonPath("$[0].productId", is(1)))
                .andExpect(status().isOk());
    }
}