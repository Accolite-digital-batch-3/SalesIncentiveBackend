package com.example.SalesIncentiveBackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SalesIncentiveBackend.model.SalesPerson;


public interface SalesPersonRepository extends JpaRepository<SalesPerson,Long>{
	
	

}
