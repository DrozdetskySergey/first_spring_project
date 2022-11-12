package com.happy.drozdetskiy.corporation.controller;

import com.happy.drozdetskiy.corporation.controller.DTO.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CorporationController {

    private final EmployeeService employeeService;

    @Autowired
    public CorporationController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/")
    public String showAllEmployees(Model model) {
        List<EmployeeControllerDTO> employees = employeeService.getAll();

        model.addAttribute("allEmployees", employees);

        return "all-employees";
    }

    @GetMapping(value = "/edit")
    public String editEmployee() {
        return "edit";
    }
}
