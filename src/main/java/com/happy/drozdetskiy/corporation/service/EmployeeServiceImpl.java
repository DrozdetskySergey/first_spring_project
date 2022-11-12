package com.happy.drozdetskiy.corporation.service;

import com.happy.drozdetskiy.corporation.controller.DTO.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;
import com.happy.drozdetskiy.corporation.repository.EmployeeRepository;
import com.happy.drozdetskiy.corporation.repository.EmployeeSpecification;
import com.happy.drozdetskiy.corporation.service.utils.EmployeeServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public void add(EmployeeControllerDTO employeeControllerDTO) {
        employeeRepository.add(EmployeeServiceUtils.convertToEmployeeRepositoryDTO(employeeControllerDTO));
    }

    @Override
    @Transactional
    public void delete(EmployeeControllerDTO employeeControllerDTO) {
        employeeRepository.remove(EmployeeServiceUtils.convertToEmployeeRepositoryDTO(employeeControllerDTO));
    }

    @Override
    @Transactional
    public void edit(EmployeeControllerDTO employeeControllerDTO) {
        employeeRepository.set(EmployeeServiceUtils.convertToEmployeeRepositoryDTO(employeeControllerDTO));
    }

    @Override
    @Transactional
    public EmployeeControllerDTO getById(int id) {
        List<EmployeeRepositoryDTO> list = employeeRepository.query(e -> e.getId() == id);

        return list.size() == 0 ? null : EmployeeServiceUtils.convertToEmployeeControllerDTO(list.get(0));
    }

    @Override
    @Transactional
    public List<EmployeeControllerDTO> getAllByPredicate(EmployeeSpecification specification) {
        return employeeRepository.query(specification).stream()
                .map(EmployeeServiceUtils::convertToEmployeeControllerDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<EmployeeControllerDTO> getAll() {
        return employeeRepository.query(e -> true).stream()
                .map(EmployeeServiceUtils::convertToEmployeeControllerDTO)
                .collect(Collectors.toList());
    }
}
