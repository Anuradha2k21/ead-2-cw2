package com.example.uiservice.controller;

import com.example.uiservice.data.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@CrossOrigin("http://localhost:3000")
public class HostOrderController {

    private final WebClient.Builder webClientBuilder;

    @GetMapping
    public Flux<Order> getOrder(){
        return webClientBuilder.build().get()
                .uri("http://order-service/api/orders")
                .retrieve()
                .bodyToFlux(Order.class);
    }
    @PostMapping
    public Mono<String> createOrder(@RequestBody Order order) {
        return webClientBuilder.build().post()
                .uri("http://order-service/api/orders")
                .syncBody(order)
                .retrieve()
                .bodyToMono(String.class);
    }
    @GetMapping(path = "/{id}")
    public Flux<Order> getOrderById(@PathVariable int id) {
        return webClientBuilder.build().get()
                .uri("http://order-service/api/orders/" + id)
                .retrieve()
                .bodyToFlux(Order.class);
    }
    @DeleteMapping(path = "/{id}")
    public Mono<String> deleteOrderById(@PathVariable int id) {
        return webClientBuilder.build().delete()
                .uri("http://order-service/api/orders/" + id)
                .retrieve()
                .bodyToMono(String.class);
    }
    @PutMapping
    public Mono<Order> updateOrder(@RequestBody Order order) {
        return webClientBuilder.build().put()
                .uri("http://order-service/api/orders")
                .syncBody(order)
                .retrieve()
                .bodyToMono(Order.class);
    }

}
