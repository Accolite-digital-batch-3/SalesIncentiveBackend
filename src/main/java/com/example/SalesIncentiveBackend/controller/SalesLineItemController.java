package com.example.SalesIncentiveBackend.controller;


import java.util.List;

import com.example.SalesIncentiveBackend.CSVHelper;
import com.example.SalesIncentiveBackend.model.SalesLineItem;
import com.example.SalesIncentiveBackend.service.SalesLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin("*")
@Controller
@RequestMapping("sales-line-item")
public class SalesLineItemController {

    @Autowired
    SalesLineItemService salesLineItemService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        System.out.println(CSVHelper.hasCSVFormat(file));
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                salesLineItemService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return new ResponseEntity<>(message, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return new ResponseEntity<>(message,HttpStatus.EXPECTATION_FAILED);
            }
        }
        message = "Please upload a csv file!";
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SalesLineItem>> findAllSalesLineItem() {
        try {
            List<SalesLineItem> salesLineItems = salesLineItemService.findAllSaleLineItem();
            if (salesLineItems.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(salesLineItems, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
