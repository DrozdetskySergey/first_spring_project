package com.happy.drozdetskiy.corporation.repository;

import com.happy.drozdetskiy.corporation.entity.Employee;
import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;
import com.happy.drozdetskiy.corporation.repository.utils.EmployeeRepositoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(EmployeeRepositoryDTO employeeRepositoryDTO) {

    }

    @Override
    public void remove(EmployeeRepositoryDTO employeeRepositoryDTO) {

    }

    @Override
    public void set(EmployeeRepositoryDTO employeeRepositoryDTO) {

    }

    @Override
    public List<EmployeeRepositoryDTO> query(EmployeeSpecification specification) {
        Session session = sessionFactory.getCurrentSession();

        List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();

        return employees.stream()
                .map(EmployeeRepositoryUtils::convertToEmployeeRepositoryDTO)
                .filter(specification::specified)
                .collect(Collectors.toList());
    }
}
