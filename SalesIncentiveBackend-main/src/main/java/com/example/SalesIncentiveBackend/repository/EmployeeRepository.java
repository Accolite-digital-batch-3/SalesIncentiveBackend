package com.example.SalesIncentiveBackend.repository;

import com.example.SalesIncentiveBackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT u FROM Employee u WHERE u.empEmail = ?1 and u.empPassword=?2")
    public Employee findByEmail(String email,String password);
}
