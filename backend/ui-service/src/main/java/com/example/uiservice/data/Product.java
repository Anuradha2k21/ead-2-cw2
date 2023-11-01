package com.example.uiservice.data;

import lombok.Data;

@Data
public class Product {

    private int productId;
    private String name;
    private String description;
    private int quantity;
    private String category;
    private double price;

}
