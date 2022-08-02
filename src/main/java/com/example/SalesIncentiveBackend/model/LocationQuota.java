package com.example.SalesIncentiveBackend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="location")
@Getter
@Setter
public class LocationQuota {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="location_id")
    private int locationId;

    @Column(name="location")
    private String location;

    @Column(name="quota_amount")
    private BigDecimal quotaAmount;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "location")
    private List<Employee> employees;
}
