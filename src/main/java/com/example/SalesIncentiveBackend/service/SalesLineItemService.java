package com.example.SalesIncentiveBackend.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.SalesIncentiveBackend.CSVHelper;
import com.example.SalesIncentiveBackend.dto.SalesLineItemDto;
import com.example.SalesIncentiveBackend.mapper.SalesLineItemMapper;
import com.example.SalesIncentiveBackend.model.SalesLineItem;
import com.example.SalesIncentiveBackend.repository.SalesLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SalesLineItemService {
    @Autowired
    private SalesLineItemRepository salesLineItemRepository;

   private EmployeeService employeeService;

    private ProductService productService;

    public SalesLineItemService(SalesLineItemRepository salesLineItemRepository, EmployeeService employeeService, ProductService productService) {
        this.salesLineItemRepository = salesLineItemRepository;
        this.employeeService = employeeService;
        this.productService = productService;
    }


    public void save(MultipartFile file) {
        try {
            List<SalesLineItemDto> salesLineDtoItems = CSVHelper.csvToSalesLineItems(file.getInputStream());
            System.out.println("after csvtosales");
            List<SalesLineItem> salesLineItems=new ArrayList<>();

            for(SalesLineItemDto item:salesLineDtoItems){
                SalesLineItem salesLineItem= SalesLineItemMapper.INSTANCE.dtoToModel(item);
                salesLineItem.setEmployee(employeeService.findByEmpId(item.getEmpId()));
                salesLineItem.setProduct(productService.findById(item.getProductId()));
                salesLineItem.setSoldDate(item.getSoldDate());
                salesLineItem.setSoldCost(item.getSoldCost());
                salesLineItems.add(salesLineItem);
            }
            salesLineItemRepository.saveAll(salesLineItems);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<SalesLineItem> findAllSaleLineItem()
    {
        return salesLineItemRepository.findAll();
    }
}
