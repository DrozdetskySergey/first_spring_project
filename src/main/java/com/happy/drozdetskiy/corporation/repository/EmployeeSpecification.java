package com.happy.drozdetskiy.corporation.repository;

import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;

public interface EmployeeSpecification {

    boolean specified(EmployeeRepositoryDTO employeeRepositoryDTO);
}
