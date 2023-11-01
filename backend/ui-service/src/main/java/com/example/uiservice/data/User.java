package com.example.uiservice.data;

import lombok.Data;

@Data
public class User {
    private int userId;
    private String role;
    private String name;
    private String email;
    private String password;
    private String address;
    private String telephoneNumber;
}
