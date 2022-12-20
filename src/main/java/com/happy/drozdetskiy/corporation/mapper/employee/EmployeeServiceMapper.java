package com.happy.drozdetskiy.corporation.mapper.employee;

import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeRepositoryDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeServiceMapper {

    EmployeeRepositoryDTO toEmployeeRepositoryDTO(EmployeeControllerDTO employeeControllerDTO);

    EmployeeControllerDTO toEmployeeControllerDTO(EmployeeRepositoryDTO employeeRepositoryDTO);
}
