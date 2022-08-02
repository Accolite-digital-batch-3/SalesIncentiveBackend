package com.example.SalesIncentiveBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="product_id")
    private int productId;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="type_id",nullable = false)
    private ProductType type;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private List<SalesLineItem> salesLineItems;

    @Column(name="product_name")
    private String productName;

    @Column(name="cost")
    private BigDecimal cost;

}
