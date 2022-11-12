package com.happy.drozdetskiy.corporation.repository.utils;

import com.happy.drozdetskiy.corporation.entity.Employee;
import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;

public class EmployeeRepositoryUtils {

    public static EmployeeRepositoryDTO convertToEmployeeRepositoryDTO(Employee employee) {
        EmployeeRepositoryDTO employeeRepositoryDTO = new EmployeeRepositoryDTO();
        employeeRepositoryDTO.id = employee.getId();
        employeeRepositoryDTO.name = employee.getName();
        employeeRepositoryDTO.surname = employee.getSurname();
        employeeRepositoryDTO.department = employee.getDepartment();
        employeeRepositoryDTO.salary = employee.getSalary();

        return  employeeRepositoryDTO;
    }

    public static Employee convertToEmployee(EmployeeRepositoryDTO employeeRepositoryDTO) {
        return new Employee(
                employeeRepositoryDTO.id,
                employeeRepositoryDTO.name,
                employeeRepositoryDTO.surname,
                employeeRepositoryDTO.department,
                employeeRepositoryDTO.salary);
    }
}
