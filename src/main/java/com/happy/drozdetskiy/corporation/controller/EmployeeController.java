package com.happy.drozdetskiy.corporation.controller;

import com.happy.drozdetskiy.corporation.DTO.employee.EmployeeControllerDTO;
import com.happy.drozdetskiy.corporation.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<EmployeeControllerDTO> employees = service.getAll();

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
            service.add(employeeControllerDTO);
        } else {
            service.edit(employeeControllerDTO);
        }

        return "redirect:/";
    }

    @RequestMapping("/editEmployee")
    public String editEmployee(@RequestParam("employeeId") int id, Model model) {
        Optional<EmployeeControllerDTO> optional = service.getById(id);

        if (optional.isPresent()) {
            model.addAttribute("employee", optional.get());

            return "employee-info";
        }

        return "redirect:/";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        service.getById(id).ifPresent(service::delete);

        return "redirect:/";
    }
}
