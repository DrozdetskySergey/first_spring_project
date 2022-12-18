package com.happy.drozdetskiy.corporation.repository.employee.impl;

import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeRepositoryDTO;
import com.happy.drozdetskiy.corporation.entity.Employee;
import com.happy.drozdetskiy.corporation.mapper.employee.EmployeeRepositoryMapper;
import com.happy.drozdetskiy.corporation.repository.Specification;
import com.happy.drozdetskiy.corporation.repository.employee.EmployeeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final SessionFactory sessionFactory;
    private final EmployeeRepositoryMapper employeeRepositoryMapper; // generated with Mapstruct

    @Autowired
    public EmployeeRepositoryImpl(SessionFactory sessionFactory, EmployeeRepositoryMapper employeeRepositoryMapper) {
        this.sessionFactory = sessionFactory;
        this.employeeRepositoryMapper = employeeRepositoryMapper;
    }

    @Override
    public void add(EmployeeRepositoryDTO employeeRepositoryDTO) {
        Session session = sessionFactory.getCurrentSession();

        session.save(employeeRepositoryMapper.toEmployee(employeeRepositoryDTO));
    }

    @Override
    public void remove(EmployeeRepositoryDTO employeeRepositoryDTO) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(employeeRepositoryMapper.toEmployee(employeeRepositoryDTO));
    }

    @Override
    public void set(EmployeeRepositoryDTO employeeRepositoryDTO) {
        Session session = sessionFactory.getCurrentSession();

        session.update(employeeRepositoryMapper.toEmployee(employeeRepositoryDTO));
    }

    @Override
    public List<EmployeeRepositoryDTO> query(Specification<EmployeeRepositoryDTO> specification) {
        Session session = sessionFactory.getCurrentSession();

        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();

        return employees.stream()
                .map(employeeRepositoryMapper::toRepositoryDTO)
                .filter(specification::specified)
                .collect(Collectors.toList());
    }
}
