package com.example.SalesIncentiveBackend.mapper;

import com.example.SalesIncentiveBackend.dto.EmployeeDto;
import com.example.SalesIncentiveBackend.model.Employee;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-02T16:52:02+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto modelToDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmpId( employee.getEmpId() );
        employeeDto.setEmpName( employee.getEmpName() );
        employeeDto.setEmpEmail( employee.getEmpEmail() );
        employeeDto.setEmpPassword( employee.getEmpPassword() );
        employeeDto.setRole( employee.getRole() );

        return employeeDto;
    }

    @Override
    public Employee dtoToModel(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setEmpId( employeeDto.getEmpId() );
        employee.setEmpName( employeeDto.getEmpName() );
        employee.setEmpEmail( employeeDto.getEmpEmail() );
        employee.setEmpPassword( employeeDto.getEmpPassword() );
        employee.setRole( employeeDto.getRole() );

        return employee;
    }
}
