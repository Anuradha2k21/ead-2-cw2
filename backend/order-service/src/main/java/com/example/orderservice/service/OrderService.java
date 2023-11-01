package com.example.orderservice.service;

import com.example.orderservice.data.Order;
import com.example.orderservice.data.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor    //  create all required constructors at runtime
public class OrderService {

    private final OrderRepository orderRepository;
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order findOrderById(int orderId){
        Optional<Order> obj=orderRepository.findById(orderId);
        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }
    public void deleteOrder(int orderId){
        orderRepository.deleteById(orderId);
    }
    public Order updateOrder(Order order){
        return orderRepository.save(order);
    }

}
