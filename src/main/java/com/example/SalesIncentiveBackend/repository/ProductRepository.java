package com.example.SalesIncentiveBackend.repository;

import com.example.SalesIncentiveBackend.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
