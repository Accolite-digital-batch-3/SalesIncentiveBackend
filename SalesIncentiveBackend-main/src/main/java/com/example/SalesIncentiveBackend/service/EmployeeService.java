package com.example.SalesIncentiveBackend.service;

import com.example.SalesIncentiveBackend.model.Employee;
import com.example.SalesIncentiveBackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(int employeeId)
	{
		employeeRepository.deleteById(employeeId);
	}

	public List<Employee> findAllEmployee()
	{
		return employeeRepository.findAll();
	}

	public Employee employeeLogin(String email,String password){

		return employeeRepository.findByEmail(email,password);
	}


	

}
