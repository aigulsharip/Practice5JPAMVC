package com.example.practice3jpa.service;

import com.example.practice3jpa.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findProductById(Long id);
    List<Product> findAllWithClient();
    void delete(Product product);



}
