package com.example.uiservice.controller;

import com.example.uiservice.data.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class HostUserController {

    private final WebClient.Builder webClientBuilder;

    @GetMapping
    public Flux<User> getUsers(){
        return webClientBuilder.build().get()
                .uri("http://user-service/api/users")
                .retrieve()
                .bodyToFlux(User.class);
    }
    @PostMapping
    public Mono<String> createUser(@RequestBody User user) {
        return webClientBuilder.build().post()
                .uri("http://user-service/api/users")
                .syncBody(user)
                .retrieve()
                .bodyToMono(String.class);
    }
    @GetMapping(path = "/{userId}")
    public Flux<User> getUserById(@PathVariable int userId) {
        return webClientBuilder.build().get()
                .uri("http://user-service/api/users/" + userId)
                .retrieve()
                .bodyToFlux(User.class);
    }
    @DeleteMapping(path = "/{userId}")
    public Mono<String> deleteUserById(@PathVariable int userId) {
        return webClientBuilder.build().delete()
                .uri("http://user-service/api/users/" + userId)
                .retrieve()
                .bodyToMono(String.class);
    }
    @PutMapping(path = "/{userId}")
    public Mono<User> updateUser(@RequestBody User user, @PathVariable int userId) {
        return webClientBuilder.build().put()
                .uri("http://user-service/api/users/" + userId)
                .syncBody(user)
                .retrieve()
                .bodyToMono(User.class);
    }

    @GetMapping(params="name")
    public Flux<User> getUserByName(@RequestParam String name) {
        return webClientBuilder.build().get()
                .uri("http://user-service/api/users?name="+name)
                .retrieve()
                .bodyToFlux(User.class);
    }
}
