package com.example.orderservice.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;
    @Column(name = "total_price")
    private double totalPrice;
}
