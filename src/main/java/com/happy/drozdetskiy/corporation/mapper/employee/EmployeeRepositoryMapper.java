package com.happy.drozdetskiy.corporation.mapper.employee;

import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeRepositoryDTO;
import com.happy.drozdetskiy.corporation.entity.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeRepositoryMapper {

    EmployeeRepositoryDTO toEmployeeRepositoryDTO(Employee employee);

    Employee toEmployee(EmployeeRepositoryDTO employeeRepositoryDTO);
}
