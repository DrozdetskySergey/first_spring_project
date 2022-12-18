package com.happy.drozdetskiy.corporation.controller;

import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.mapper.employee.EmployeeRepositoryMapper;
import com.happy.drozdetskiy.corporation.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepositoryMapper employeeRepositoryMapper;

    @Autowired
    public EmployeeController(@Qualifier("employeeServiceImpl") EmployeeService employeeService, EmployeeRepositoryMapper employeeRepositoryMapper) {
        this.employeeService = employeeService;
        this.employeeRepositoryMapper = employeeRepositoryMapper;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<EmployeeControllerDTO> employees = employeeService.getAll();

        model.addAttribute("allEmployees", employees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        EmployeeControllerDTO employeeControllerDTO = new EmployeeControllerDTO();

        model.addAttribute("employee", employeeControllerDTO);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeControllerDTO employeeControllerDTO) {
        if (employeeControllerDTO.getId() == 0) {
            employeeService.add(employeeControllerDTO);
        } else {
            employeeService.edit(employeeControllerDTO);
        }

        return "redirect:/";
    }

    @RequestMapping("/editEmployee")
    public String editEmployee(@RequestParam("employeeId") int id, Model model) {
        EmployeeControllerDTO employeeControllerDTO = employeeService.getById(id);

        model.addAttribute("employee", employeeControllerDTO);

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        EmployeeControllerDTO employeeControllerDTO = employeeService.getById(id); //TODO

        if (employeeControllerDTO != null) {
            employeeService.delete(employeeControllerDTO);
        }

        return "redirect:/";
    }
}
