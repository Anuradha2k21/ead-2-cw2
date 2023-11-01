package com.example.productservice.service;

import com.example.productservice.data.Product;
import com.example.productservice.data.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor    //  create all required constructors at runtime
public class ProductService {

    private final ProductRepository productRepository;
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product findProductById(int productId){
        Optional<Product> obj=productRepository.findById(productId);
        if(obj.isPresent()){
            return obj.get();
        }
        return null;
    }
    public void deleteProduct(int productId){
        productRepository.deleteById(productId);
    }
    public Product updateProduct(Product newProduct, int productId){
        return productRepository.findById(productId)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setQuantity(newProduct.getQuantity());
                    product.setCategory(newProduct.getCategory());
                    product.setPrice(newProduct.getPrice());
                    return productRepository.save(product);
                }).orElseThrow(() -> new RuntimeException());
    }
    public List<Product> searchByProductName(String name){
        return productRepository.searchByProductName(name);
    }
}
