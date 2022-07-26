package com.example.SalesIncentiveBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SalesIncentiveBackend.model.Admin;
import com.example.SalesIncentiveBackend.service.AdminService;


@CrossOrigin("*")
@RestController
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/adminlogin")
	public Boolean checkUser(@RequestBody Admin admin)
	{
		return adminService.addLogin(admin);
	}
	
}
