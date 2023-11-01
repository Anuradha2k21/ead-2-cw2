package com.example.userservice.controller;

import com.example.userservice.data.User;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor    //  to create all required constructors at runtime
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping(path = "/{userId}")
    public User findUserById(@PathVariable int userId){
        return userService.findUserById(userId);
    }
    @DeleteMapping(path = "/{userId}")
    public String deleteUser(@PathVariable int userId){
        return userService.deleteUser(userId);
    }
    @PutMapping(path = "/{userId}")
    public User updateUser(@RequestBody User user,@PathVariable int userId){
        return userService.updateUser(user,userId);
    }
    @GetMapping(params = "name")
    public List<User> searchByUserName(@RequestParam String name){
        return userService.searchByUserName(name);
    }

}
