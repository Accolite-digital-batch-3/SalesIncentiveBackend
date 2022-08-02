package com.example.SalesIncentiveBackend.repository;

import com.example.SalesIncentiveBackend.model.ProductType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productType",path="product-type")
public interface ProductTypeRepository extends JpaRepository<ProductType,Integer> {
}
