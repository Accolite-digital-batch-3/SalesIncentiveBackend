package com.example.SalesIncentiveBackend.service;

import com.example.SalesIncentiveBackend.model.Employee;
import com.example.SalesIncentiveBackend.model.Product;
import com.example.SalesIncentiveBackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(int productId){
        return productRepository.findById(productId);
    }
}
