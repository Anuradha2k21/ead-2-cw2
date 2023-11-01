package com.example.productservice.controller;

import com.example.productservice.data.Product;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor    //  to create all required constructors at runtime
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping(path = "/{productId}")
    public Product findProductById(@PathVariable int productId){
        return productService.findProductById(productId);
    }
    @DeleteMapping(path = "/{productId}")
    public void deleteProduct(@PathVariable int productId){
        productService.deleteProduct(productId);
    }
    @PutMapping(path = "/{productId}")
    public Product updateProduct(@RequestBody Product product,@PathVariable int productId){
        return productService.updateProduct(product,productId);
    }
    @GetMapping(params = "name")
    public List<Product> searchByProductName(@RequestParam String name){
        return productService.searchByProductName(name);
    }

}
