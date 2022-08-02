package com.example.SalesIncentiveBackend.repository;

import com.example.SalesIncentiveBackend.model.SalesLineItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "salesLineItem",path="sales-line-item")
public interface SalesLineItemRepository extends JpaRepository<SalesLineItem,Integer> {
}
