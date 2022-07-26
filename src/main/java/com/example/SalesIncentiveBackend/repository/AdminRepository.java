package com.example.SalesIncentiveBackend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SalesIncentiveBackend.model.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin,String>{
	

}
