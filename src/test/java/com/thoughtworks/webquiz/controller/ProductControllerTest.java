package com.thoughtworks.webquiz.controller;

import com.thoughtworks.webquiz.domain.Order;
import com.thoughtworks.webquiz.domain.Product;
import com.thoughtworks.webquiz.dto.ProductDto;
import com.thoughtworks.webquiz.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();

    }

    @Test
    void should_return_products_list_when_get() throws Exception {

        mockMvc.perform(get("/product"))
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[0].name", is("可乐1")))
                .andExpect(jsonPath("$[0].price", is(1)))
                .andExpect(jsonPath("$[0].unit", is("瓶")))
                .andExpect(status().isOk());
    }

    @Test
    void should_get_product_when_user_choose_product_by_id() throws Exception {
        //String jsonValue = "{\"name\":\"可乐1\",\"price\":1,\"count\":1,\"unit\":\"瓶\",\"productId\":1 }";

        ProductDto productDto1 =
                ProductDto.builder()
                        .name("可乐1")
                        .price(1)
                        .unit("瓶")
                        .build();

        productRepository.save(productDto1);

        mockMvc.perform(get("/product/1"))
                .andExpect(jsonPath("$.name", is("可乐1")))
                .andExpect(jsonPath("$.price", is(1)))
                .andExpect(jsonPath("$.unit", is("瓶")))
                .andExpect(status().isOk());
    }
}
