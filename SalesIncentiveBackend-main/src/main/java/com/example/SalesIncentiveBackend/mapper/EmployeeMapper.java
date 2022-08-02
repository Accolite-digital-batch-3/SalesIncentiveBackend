package com.example.SalesIncentiveBackend.mapper;

import com.example.SalesIncentiveBackend.dto.EmployeeDto;
import com.example.SalesIncentiveBackend.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    EmployeeDto modelToDto(Employee employee);

    Employee dtoToModel(EmployeeDto employeeDto);
}
