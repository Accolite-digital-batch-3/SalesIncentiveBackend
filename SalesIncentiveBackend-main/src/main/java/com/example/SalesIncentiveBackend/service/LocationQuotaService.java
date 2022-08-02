package com.example.SalesIncentiveBackend.service;

import com.example.SalesIncentiveBackend.model.LocationQuota;
import com.example.SalesIncentiveBackend.repository.LocationQuotaRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationQuotaService {

    private LocationQuotaRepository locationQuotaRepository;

    public LocationQuotaService(LocationQuotaRepository locationQuotaRepository) {
        this.locationQuotaRepository = locationQuotaRepository;

    }

    public LocationQuota findByLocationId(int locationId){

        return locationQuotaRepository.findByLocationId(locationId);
    }
}
