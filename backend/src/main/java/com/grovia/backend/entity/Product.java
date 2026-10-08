package com.grovia.backend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;


@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock;

    public Long getId() {
    return id;
}

public String getName() {
    return name;
}

public String getDescription() {
    return description;
}

public BigDecimal getPrice() {
    return price;
}

public Integer getStock() {
    return stock;
}
}