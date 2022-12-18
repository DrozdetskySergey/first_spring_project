package com.happy.drozdetskiy.corporation.service.employee;

import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeRepositoryDTO;
import com.happy.drozdetskiy.corporation.repository.Specification;
import com.happy.drozdetskiy.corporation.service.Service;

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
