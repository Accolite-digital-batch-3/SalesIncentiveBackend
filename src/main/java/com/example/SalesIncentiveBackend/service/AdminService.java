package com.example.SalesIncentiveBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SalesIncentiveBackend.model.Admin;
import com.example.SalesIncentiveBackend.repository.AdminRepository;


@Service
public class AdminService {
	@Autowired
    private AdminRepository userRepo;
	
	
	public Boolean addLogin(Admin admin)
	{
		if(!userRepo.existsById(admin.getEmail())) {
            //the user is not registered in our database, user model table
            return false;
        }
		
		if(userRepo.existsById(admin.getEmail())) {
	            //the user is already logged in
	            return true;
	        }
		if(admin.getPassword().equals(userRepo.findById(admin.getEmail()).get().getPassword())) {
	            userRepo.save(admin);
	            return true;
	        } 
		else{
	            return false;
	        }
	}

}
