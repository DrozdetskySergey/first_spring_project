package com.happy.drozdetskiy.corporation.repository;

import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;

import java.util.List;

public interface EmployeeRepository {

    void add(EmployeeRepositoryDTO employeeRepositoryDTO);

    void remove(EmployeeRepositoryDTO employeeRepositoryDTO);

    void set(EmployeeRepositoryDTO employeeRepositoryDTO);

    List<EmployeeRepositoryDTO> query(EmployeeSpecification specification);
}
