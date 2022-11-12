package com.happy.drozdetskiy.corporation.service;

import com.happy.drozdetskiy.corporation.controller.DTO.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.repository.EmployeeSpecification;

import java.util.List;

public interface EmployeeService {

    void add(EmployeeControllerDTO dto);

    void delete(EmployeeControllerDTO dto);

    void edit(EmployeeControllerDTO dto);

    EmployeeControllerDTO getById(int id);

    List<EmployeeControllerDTO> getAllByPredicate(EmployeeSpecification specification);

    List<EmployeeControllerDTO> getAll();
}
