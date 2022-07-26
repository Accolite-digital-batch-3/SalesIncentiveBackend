package com.example.SalesIncentiveBackend.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.SalesIncentiveBackend.model.SalesPerson;
import com.example.SalesIncentiveBackend.repository.SalesPersonRepository;

@Service
public class SalesPersonService {
	
	private final SalesPersonRepository salesrepo;
	
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
	

	
	

}
