package com.example.SalesIncentiveBackend.repository;

import com.example.SalesIncentiveBackend.model.Employee;
import com.example.SalesIncentiveBackend.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository  extends JpaRepository<Product, Integer> {

    @Query("SELECT u FROM Product u WHERE u.productId = ?1")
    public Product findById(int productId);
}
