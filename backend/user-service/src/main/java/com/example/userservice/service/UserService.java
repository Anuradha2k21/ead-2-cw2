package com.example.userservice.service;

import com.example.userservice.data.User;
import com.example.userservice.data.UserRepository;
import com.example.userservice.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor    //  create all required constructors at runtime
public class UserService {

    private final UserRepository userRepository;

    @ExceptionHandler
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @ExceptionHandler
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @ExceptionHandler
    public User findUserById(int userId) {
        Optional<User> obj = userRepository.findById(userId);
        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

    @ExceptionHandler
    public String deleteUser(int userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
        return "User with id " + userId + " has successfully deleted.";

    }

    @ExceptionHandler
    public User updateUser(User newUser, int userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setRole(newUser.getRole());
                    user.setAddress(newUser.getAddress());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    user.setTelephoneNumber(newUser.getTelephoneNumber());
                    return userRepository.save(user);
                }).orElseThrow(() -> new RuntimeException());
    }

    @ExceptionHandler
    public List<User> searchByUserName(String name) {
        return userRepository.searchByUserName(name);
    }
}
