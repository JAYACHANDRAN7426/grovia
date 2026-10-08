package com.grovia.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grovia.backend.entity.Product;
import com.grovia.backend.repository.ProductRepository;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
