package com.example.SalesIncentiveBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="sales_line_item")
@Data
public class SalesLineItem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="sales_id")
    private int salesId;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="emp_id",nullable = false)
    private Employee employee;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="product_id",nullable = false)
    private Product product;


    @Column(name="sold_date")
    private Date soldDate;

    @Column(name="sold_cost")
    private BigDecimal soldCost;



}
