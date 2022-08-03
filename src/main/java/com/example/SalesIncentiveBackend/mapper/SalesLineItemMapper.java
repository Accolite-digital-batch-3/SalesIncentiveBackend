package com.example.SalesIncentiveBackend.mapper;

import com.example.SalesIncentiveBackend.dto.EmployeeDto;
import com.example.SalesIncentiveBackend.dto.SalesLineItemDto;
import com.example.SalesIncentiveBackend.model.Employee;
import com.example.SalesIncentiveBackend.model.SalesLineItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SalesLineItemMapper {


    SalesLineItemMapper INSTANCE = Mappers.getMapper(SalesLineItemMapper.class);
    SalesLineItemDto modelToDto(SalesLineItem salesLineItem);

    SalesLineItem dtoToModel(SalesLineItemDto salesLineItemDto);
}
