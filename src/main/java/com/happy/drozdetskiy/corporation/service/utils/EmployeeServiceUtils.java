package com.happy.drozdetskiy.corporation.service.utils;

import com.happy.drozdetskiy.corporation.controller.DTO.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.repository.DTO.EmployeeRepositoryDTO;

public class EmployeeServiceUtils {

    public static EmployeeRepositoryDTO convertToEmployeeRepositoryDTO(EmployeeControllerDTO employeeControllerDTO) {
        return new EmployeeRepositoryDTO(
                employeeControllerDTO.getId(),
                employeeControllerDTO.getName(),
                employeeControllerDTO.getSurname(),
                employeeControllerDTO.getDepartment(),
                employeeControllerDTO.getSalary()
        );
    }

    public static EmployeeControllerDTO convertToEmployeeControllerDTO(EmployeeRepositoryDTO employeeRepositoryDTO) {
        return new EmployeeControllerDTO(
                employeeRepositoryDTO.getId(),
                employeeRepositoryDTO.getName(),
                employeeRepositoryDTO.getSurname(),
                employeeRepositoryDTO.getDepartment(),
                employeeRepositoryDTO.getSalary());
    }
}
