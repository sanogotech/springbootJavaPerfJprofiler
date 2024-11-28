package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Create
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Read All
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Read One
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Update
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());
        
        return productRepository.save(product);
    }

    // Delete
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        
        productRepository.delete(product);
    }
}
