package com.happy.drozdetskiy.corporation.repository.utils;

import com.happy.drozdetskiy.corporation.entity.Employee;
import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;

public class EmployeeRepositoryUtils {

    public static EmployeeRepositoryDTO convertToEmployeeRepositoryDTO(Employee employee) {
        return new EmployeeRepositoryDTO(
                employee.getId(),
                employee.getName(),
                employee.getSurname(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

    public static Employee convertToEmployee(EmployeeRepositoryDTO employeeRepositoryDTO) {
        return new Employee(
                employeeRepositoryDTO.getName(),
                employeeRepositoryDTO.getSurname(),
                employeeRepositoryDTO.getDepartment(),
                employeeRepositoryDTO.getSalary());
    }
}
