package com.example.productservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query("select p from Product p where p.name= :name")
    List<Product> searchByProductName(@Param("name") String name);
}
