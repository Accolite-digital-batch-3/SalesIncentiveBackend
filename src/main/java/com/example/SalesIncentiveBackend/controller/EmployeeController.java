package com.example.SalesIncentiveBackend.controller;

import com.example.SalesIncentiveBackend.dto.EmployeeDto;
import com.example.SalesIncentiveBackend.mapper.EmployeeMapper;
import com.example.SalesIncentiveBackend.model.Employee;

import com.example.SalesIncentiveBackend.model.LocationQuota;
import com.example.SalesIncentiveBackend.service.EmployeeService;
import com.example.SalesIncentiveBackend.service.LocationQuotaService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService, LocationQuotaService locationQuotaService) {
        this.employeeService = employeeService;
        this.locationQuotaService = locationQuotaService;
    }

    private LocationQuotaService locationQuotaService;
    @PostMapping("/login")
    public ResponseEntity<Employee> employeeLogin(@RequestBody ObjectNode json)
    {
        String email=json.get("email").asText();
        String password=json.get("password").asText();
        Employee emp=employeeService.employeeLogin(email,password);

        return new ResponseEntity<>(emp, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employees=employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        //employeeDto.setEmpId(0);
        Employee newemployee= EmployeeMapper.INSTANCE.dtoToModel(employeeDto);
        LocationQuota location=locationQuotaService.findByLocationId(employeeDto.getLocationId());
        newemployee.setLocation(location);
        newemployee=employeeService.addEmployee(newemployee);
        return new ResponseEntity<>(newemployee,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> findById(@PathVariable int employeeId)
    {
        Employee employee=employeeService.findByEmpId(employeeId);

        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
