package com.vasy.resttemplate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vasy.resttemplate.dto.EmployeeDTO;
import com.vasy.resttemplate.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

    @GetMapping("/employees")
    private List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    private EmployeeDTO getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    private EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
        employeeService.saveOrUpdate(employee);
        return employee;
    }

    @PutMapping("/employees/{id}")
    private EmployeeDTO updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDTO employee) {
        EmployeeDTO updatedEmployee = employeeService.getEmployeeById(id);
        updatedEmployee.setName(employee.getName());
        updatedEmployee.setSalary(employee.getSalary());
        employeeService.saveOrUpdate(updatedEmployee);
        return updatedEmployee;
    }

    @DeleteMapping("/employees/{id}")
    private EmployeeDTO deleteById(@PathVariable("id") int id) {
        EmployeeDTO employeeDeleted = employeeService.getEmployeeById(id);
        employeeService.deleteEmployeeById(id);
        return employeeDeleted;
    }
}
	

