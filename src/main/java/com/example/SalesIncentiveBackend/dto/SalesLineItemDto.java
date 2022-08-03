package com.example.SalesIncentiveBackend.dto;


import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SalesLineItemDto {

    private int salesId;
    private int empId;
    private int productId;
    private Date soldDate;
    private BigDecimal soldCost;

}
