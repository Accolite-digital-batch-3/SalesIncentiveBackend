package com.example.SalesIncentiveBackend.dto;

import com.example.SalesIncentiveBackend.model.LocationQuota;
import com.example.SalesIncentiveBackend.model.SalesLineItem;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class EmployeeDto {

    private int empId;

    private int locationId;

    private String empName;

    private String empEmail;

    private String empPassword;

    private String role;

    private int reportingHeadId;

}
