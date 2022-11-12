package com.happy.drozdetskiy.corporation.service.utils;

import com.happy.drozdetskiy.corporation.controller.DTO.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;

import java.util.Locale;

public class EmployeeServiceUtils {

    public static EmployeeRepositoryDTO convertToEmployeeRepositoryDTO(EmployeeControllerDTO employeeControllerDTO) {
        EmployeeRepositoryDTO employeeRepositoryDTO = new EmployeeRepositoryDTO();

        employeeRepositoryDTO.id = employeeControllerDTO.id;
        employeeRepositoryDTO.name = employeeControllerDTO.name;
        employeeRepositoryDTO.surname = employeeControllerDTO.surname;
        employeeRepositoryDTO.department = employeeControllerDTO.department.toLowerCase(Locale.ROOT);
        employeeRepositoryDTO.salary = employeeControllerDTO.salary;

        return employeeRepositoryDTO;
    }

    public static EmployeeControllerDTO convertToEmployeeControllerDTO(EmployeeRepositoryDTO employeeRepositoryDTO) {
        EmployeeControllerDTO employeeControllerDTO = new EmployeeControllerDTO();

        employeeControllerDTO.id = employeeRepositoryDTO.id;
        employeeControllerDTO.name = employeeRepositoryDTO.name;
        employeeControllerDTO.surname = employeeRepositoryDTO.surname;
        employeeControllerDTO.department = employeeRepositoryDTO.department.toUpperCase(Locale.ROOT);
        employeeControllerDTO.salary = employeeRepositoryDTO.salary;

        return employeeControllerDTO;
    }
}
