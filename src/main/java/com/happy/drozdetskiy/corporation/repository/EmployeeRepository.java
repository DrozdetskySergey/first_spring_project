package com.happy.drozdetskiy.corporation.repository;

import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;

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
