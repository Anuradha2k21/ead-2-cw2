package com.example.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
//@Testcontainers
class ProductServiceApplicationTests {
//
//    @Container
//    static MySQLContainer mysql = new MySQLContainer<>(DockerImageName.parse("mysql:8.0.34"));
//
//    static void setProperties()

    @Test
    void contextLoads() {
    }

}
