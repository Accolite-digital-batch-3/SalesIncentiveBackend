package com.example.SalesIncentiveBackend.repository;

import com.example.SalesIncentiveBackend.model.Employee;
import com.example.SalesIncentiveBackend.model.LocationQuota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.xml.stream.Location;

@RepositoryRestResource(collectionResourceRel = "locationQuota",path="location-quota")
public interface LocationQuotaRepository extends JpaRepository<LocationQuota,Integer> {

    @Query("SELECT u FROM LocationQuota u WHERE u.locationId = ?1")
    public LocationQuota findByLocationId(int locationId);
}
