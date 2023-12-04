package com.attraya.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "PRODUCT_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private int quantity;
    private long price;

    public Product(String name, int quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}