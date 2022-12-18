package com.happy.drozdetskiy.corporation.repository.employee;

import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeRepositoryDTO;
import com.happy.drozdetskiy.corporation.repository.Repository;
import com.happy.drozdetskiy.corporation.repository.Specification;

import java.util.List;

public interface EmployeeRepository extends Repository<EmployeeRepositoryDTO> {

    @Override
    void add(EmployeeRepositoryDTO employeeRepositoryDTO);

    @Override
    void remove(EmployeeRepositoryDTO employeeRepositoryDTO);

    @Override
    void set(EmployeeRepositoryDTO employeeRepositoryDTO);

    @Override
    List<EmployeeRepositoryDTO> query(Specification<EmployeeRepositoryDTO> specification);
}
