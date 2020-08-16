package com.thoughtworks.webquiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Order {
    private int id;
    private int productId;
    private String name;
    private int price;
    private int count;
    private String unit;
}
