package com.thoughtworks.webquiz.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {
    private String name;
    private int price;
    private String url;
    private String unit;
}
