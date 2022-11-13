package com.happy.drozdetskiy.corporation.service;

import com.happy.drozdetskiy.corporation.controller.DTO.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;
import com.happy.drozdetskiy.corporation.repository.Specification;

import java.util.List;

public interface EmployeeService extends Service<EmployeeControllerDTO> {

    @Override
    void add(EmployeeControllerDTO dto);

    @Override
    void delete(EmployeeControllerDTO dto);

    @Override
    void edit(EmployeeControllerDTO dto);

    @Override
    List<EmployeeControllerDTO> getAll();

    EmployeeControllerDTO getById(int id);

    List<EmployeeControllerDTO> getAllByPredicate(Specification<EmployeeRepositoryDTO> specification);
}
