package com.happy.drozdetskiy.corporation.service.employee.impl;

import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeRepositoryDTO;
import com.happy.drozdetskiy.corporation.mapper.employee.EmployeeServiceMapper;
import com.happy.drozdetskiy.corporation.repository.Specification;
import com.happy.drozdetskiy.corporation.repository.employee.EmployeeRepository;
import com.happy.drozdetskiy.corporation.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeServiceMapper employeeServiceMapper; // generated with Mapstruct

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeRepositoryImpl") EmployeeRepository employeeRepository, EmployeeServiceMapper employeeServiceMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeServiceMapper = employeeServiceMapper;
    }

    @Override
    @Transactional
    public void add(EmployeeControllerDTO employeeControllerDTO) {
        employeeRepository.add(employeeServiceMapper.toRepositoryDTO(employeeControllerDTO));
    }

    @Override
    @Transactional
    public void delete(EmployeeControllerDTO employeeControllerDTO) {
        employeeRepository.remove(employeeServiceMapper.toRepositoryDTO(employeeControllerDTO));
    }

    @Override
    @Transactional
    public void edit(EmployeeControllerDTO employeeControllerDTO) {
        employeeRepository.set(employeeServiceMapper.toRepositoryDTO(employeeControllerDTO));
    }

    @Override
    @Transactional
    public List<EmployeeControllerDTO> getAll() {
        return employeeRepository.query(e -> true).stream()
                .map(employeeServiceMapper::toControllerDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EmployeeControllerDTO getById(int id) {
        List<EmployeeRepositoryDTO> list = employeeRepository.query(e -> e.getId() == id);

        return list.size() == 0 ? null : employeeServiceMapper.toControllerDTO(list.get(0));
    }

    @Override
    @Transactional
    public List<EmployeeControllerDTO> getAllByPredicate(Specification<EmployeeRepositoryDTO> specification) {
        return employeeRepository.query(specification).stream()
                .map(employeeServiceMapper::toControllerDTO)
                .collect(Collectors.toList());
    }
}
