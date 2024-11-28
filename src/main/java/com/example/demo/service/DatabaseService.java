package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {

    @Autowired
    private ProductRepository productRepository;

    public void simulateNPlusOneProblem() {
        List<Product> products = productRepository.findAll();
        products.forEach(product -> System.out.println(product.getName() + "")); // Simule un problème N+1
    }
}
