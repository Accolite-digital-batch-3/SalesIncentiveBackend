package com.example.SalesIncentiveBackend.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SalesIncentiveBackend.model.SalesPerson;

@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPerson,Long>{
	
	Boolean existsByName(String name);
	
	Boolean deleteByName(String name);
	
	//List<SalesPerson> findByName(String name);

}
