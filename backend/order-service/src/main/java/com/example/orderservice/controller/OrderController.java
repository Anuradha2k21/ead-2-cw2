package com.example.orderservice.controller;

import com.example.orderservice.data.Order;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor    //  to create all required constructors at runtime
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }
    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping(path = "/{orderId}")
    public Order findOrderById(@PathVariable int orderId){
        return orderService.findOrderById(orderId);
    }
    @DeleteMapping(path = "/{orderId}")
    public void deleteOrder(@PathVariable int orderId){
        orderService.deleteOrder(orderId);
    }
    @PutMapping
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

}
