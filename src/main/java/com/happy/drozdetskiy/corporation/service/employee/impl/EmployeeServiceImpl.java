package com.happy.drozdetskiy.corporation.service.employee.impl;

import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeRepositoryDTO;
import com.happy.drozdetskiy.corporation.mapper.employee.EmployeeServiceMapper;
import com.happy.drozdetskiy.corporation.repository.Specification;
import com.happy.drozdetskiy.corporation.repository.employee.EmployeeRepository;
import com.happy.drozdetskiy.corporation.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeServiceMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeServiceMapper employeeServiceMapper) {
        this.repository = employeeRepository;
        this.mapper = employeeServiceMapper;
    }

    @Override
    @Transactional
    public void add(EmployeeControllerDTO employeeControllerDTO) {
        repository.add(mapper.toEmployeeRepositoryDTO(employeeControllerDTO));
    }

    @Override
    @Transactional
    public void delete(EmployeeControllerDTO employeeControllerDTO) {
        repository.remove(mapper.toEmployeeRepositoryDTO(employeeControllerDTO));
    }

    @Override
    @Transactional
    public void edit(EmployeeControllerDTO employeeControllerDTO) {
        repository.set(mapper.toEmployeeRepositoryDTO(employeeControllerDTO));
    }

    @Override
    @Transactional
    public List<EmployeeControllerDTO> getAll() {
        return repository.query(e -> true).stream()
                .map(mapper::toEmployeeControllerDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<EmployeeControllerDTO> getById(int id) {
        return repository.query(e -> e.getId() == id).stream()
                .map(mapper::toEmployeeControllerDTO)
                .findFirst();
    }

    @Override
    @Transactional
    public List<EmployeeControllerDTO> getAllByPredicate(Specification<EmployeeRepositoryDTO> specification) {
        return repository.query(specification).stream()
                .map(mapper::toEmployeeControllerDTO)
                .collect(Collectors.toList());
    }
}
