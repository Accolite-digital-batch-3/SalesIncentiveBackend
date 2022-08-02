package com.example.SalesIncentiveBackend.repository;

import com.example.SalesIncentiveBackend.model.CommissionModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "commissionModel",path="commission-model")
public interface CommissionModelRepository extends JpaRepository<CommissionModel,Integer> {
}
