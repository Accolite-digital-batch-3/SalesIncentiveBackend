package com.example.SalesIncentiveBackend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="commission_model")
@Data
public class CommissionModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="cm_id")
    private int cmId;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="type_id",nullable = false)
    private ProductType type;

    @Column(name="amount1")
    private BigDecimal amount1;

    @Column(name="amount2")
    private BigDecimal amount2;

    @Column(name="percentage")
    private int percentage;



}
