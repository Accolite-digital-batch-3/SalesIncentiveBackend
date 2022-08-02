package com.example.SalesIncentiveBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="emp_id")
    private int empId;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="location_id",nullable = false)
    private LocationQuota location;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private List<SalesLineItem> salesLineItems;

    @Column(name="emp_name")
    private String empName;

    @Column(name="emp_email")
    private String empEmail;

    @Column(name="emp_password")
    private String empPassword;

    @Column(name="role")
    private String role;
}
