package com.grovia.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grovia.backend.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}