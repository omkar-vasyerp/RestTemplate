package com.vasy.resttemplate.service;

import java.util.List;

import com.vasy.resttemplate.dto.EmployeeDTO;

public interface EmployeeService {

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getEmployeeById(int id);

	void saveOrUpdate(EmployeeDTO employeeDTO);

	void deleteEmployeeById(int id);

}
