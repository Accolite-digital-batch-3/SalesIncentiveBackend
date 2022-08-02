package com.example.SalesIncentiveBackend.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="monthly_commission")
@Data
public class MonthlyCommission {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="commission_amount")
    private BigDecimal commissionAmount;

    @Column(name="month_year")
    private int monthYear;



}
