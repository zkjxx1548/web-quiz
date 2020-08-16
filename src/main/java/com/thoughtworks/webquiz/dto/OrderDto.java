package com.thoughtworks.webquiz.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_order")
public class OrderDto {
    @Id
    @GeneratedValue
    private int id;
    private int productId;
    private String name;
    private int price;
    private int count;
    private String unit;
}
