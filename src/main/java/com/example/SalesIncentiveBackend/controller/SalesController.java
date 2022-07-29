package com.example.SalesIncentiveBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SalesIncentiveBackend.model.Admin;
import com.example.SalesIncentiveBackend.model.SalesPerson;
import com.example.SalesIncentiveBackend.service.AdminService;
import com.example.SalesIncentiveBackend.service.SalesPersonService;


@CrossOrigin("*")
@RestController
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SalesPersonService salesService;

	@PostMapping("/adminlogin")
	public Boolean checkUser(@RequestBody Admin admin)
	{
		return adminService.addLogin(admin);
	}
	
	@PostMapping("/saleslogin")
	public Boolean checkSalesUser(@RequestBody SalesPerson user)
	{
		return salesService.salesLogin(user);
	}
	
	@PostMapping("/logout")
	public Boolean logoutUser(@RequestBody String adminId)
	{
		return adminService.logoutUser(adminId);
	}
	
	@PostMapping("/salesLogout")
	public Boolean salesLogout(@RequestBody String name)
	{
		return salesService.logoutSalesUser(name);
	}
	
	
}
