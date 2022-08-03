package com.example.SalesIncentiveBackend.service;

import com.example.SalesIncentiveBackend.model.Employee;
import com.example.SalesIncentiveBackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

	public Employee findByEmpId(int empId){
		Employee employee=employeeRepository.findById(empId);
		System.out.println(employee.getEmpEmail());
		return employeeRepository.findById(empId);
	}

	public Employee employeeLogin(String email,String password){

		return employeeRepository.findByEmail(email,password);
	}


	

}
