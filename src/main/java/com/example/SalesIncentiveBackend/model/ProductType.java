package com.example.SalesIncentiveBackend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product_type")
@Getter
@Setter
public class ProductType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="type_id")
    private int typeId;

    @Column(name="type_name")
    private String typeName;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "type",fetch = FetchType.LAZY)
    private List<Product> products;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "type",fetch = FetchType.LAZY)
    private List<CommissionModel> commssionModels;
}
