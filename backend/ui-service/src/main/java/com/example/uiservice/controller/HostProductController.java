package com.example.uiservice.controller;

import com.example.uiservice.data.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
public class HostProductController {

    private final WebClient.Builder webClientBuilder;

    @GetMapping
    public Flux<Product> getProduct(){
        return webClientBuilder.build().get()
                .uri("http://product-service/api/products")
                .retrieve()
                .bodyToFlux(Product.class);
    }
    @PostMapping
    public Mono<String> createProduct(@RequestBody Product product) {
        return webClientBuilder.build().post()
                .uri("http://product-service/api/products")
                .syncBody(product)
                .retrieve()
                .bodyToMono(String.class);
    }
    @GetMapping(path = "/{id}")
    public Flux<Product> getProductById(@PathVariable int id) {
        return webClientBuilder.build().get()
                .uri("http://product-service/api/products/" + id)
                .retrieve()
                .bodyToFlux(Product.class);
    }
    @DeleteMapping(path = "/{id}")
    public Mono<String> deleteProductById(@PathVariable int id) {
        return webClientBuilder.build().delete()
                .uri("http://product-service/api/products/" + id)
                .retrieve()
                .bodyToMono(String.class);
    }
    @PutMapping(path = "/{productId}")
    public Mono<Product> updateProduct(@RequestBody Product product,@PathVariable int productId) {
        return webClientBuilder.build().put()
                .uri("http://product-service/api/products"+productId)
                .syncBody(product)
                .retrieve()
                .bodyToMono(Product.class);
    }

    @GetMapping(params="name")
    public Flux<Product> getProductByName(@RequestParam String name) {
        return webClientBuilder.build().get()
                .uri("http://product-service/api/products?name="+name)
                .retrieve()
                .bodyToFlux(Product.class);
    }
}
