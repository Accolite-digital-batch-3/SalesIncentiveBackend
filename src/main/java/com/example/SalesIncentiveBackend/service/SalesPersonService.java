package com.example.SalesIncentiveBackend.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.SalesIncentiveBackend.model.SalesPerson;
import com.example.SalesIncentiveBackend.repository.SalesPersonRepository;

@Service
public class SalesPersonService {
	

	final SalesPersonRepository salesrepo;
	
	public SalesPersonService(SalesPersonRepository salesrepo)
	{
		this.salesrepo=salesrepo;
	}
	
	public SalesPerson addUser(SalesPerson user)
	{
		return salesrepo.save(user);
	}
	
	public void deleteSalesperson(Long salesPersonId)
	{
		salesrepo.deleteById(salesPersonId);
	}
	
	public List<SalesPerson> findAllSalesPerson()
	{
		return salesrepo.findAll();
	}
	
	public Boolean salesLogin(SalesPerson user)
	{
		if(!salesrepo.existsByName(user.getName()))
		{
			return false;
		}
		if(salesrepo.existsByName(user.getName()))
		{
			return true;
		}
		if(user.getPassword().equals(salesrepo.findById(user.getSalesPersonId()).get().getPassword())) {
            salesrepo.save(user);
            return true;
        } 
		return false;
	}

	public Boolean logoutSalesUser(String name)
	{
		if(!(salesrepo.existsByName(name))){
            return true;
        }
        salesrepo.deleteByName(name);
        return (!(salesrepo.existsByName(name)));
	}
	

}
