package com.example.SalesIncentiveBackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SalesIncentiveBackend.model.SalesPerson;
import com.example.SalesIncentiveBackend.service.SalesPersonService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/salesPerson")
public class SalesPersonController {

	
	private final SalesPersonService salesPersonService;
	
	public SalesPersonController(SalesPersonService salespersonService)
	{
		this.salesPersonService=salespersonService;
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<List<SalesPerson>> getAllUsers()
	{
		List<SalesPerson> salesPersons=salesPersonService.findAllSalesPerson();
		return new ResponseEntity<>(salesPersons,HttpStatus.OK);
	}
	
	@PostMapping("/addSalesPerson")
	public ResponseEntity<SalesPerson> addUser(@RequestBody SalesPerson salesperson)
	{
		SalesPerson newsalesperson=salesPersonService.addUser(salesperson);
		return new ResponseEntity<>(newsalesperson,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteSalesPerson/{salesPersonId}")
	public ResponseEntity<?> deleteSalesPerson(@PathVariable Long salesPersonId)
	{
		salesPersonService.deleteSalesperson(salesPersonId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
