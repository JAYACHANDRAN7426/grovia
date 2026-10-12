package com.grovia.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grovia.backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
