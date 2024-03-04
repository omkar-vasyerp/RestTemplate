package com.vasy.resttemplate.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vasy.resttemplate.dto.EmployeeDTO;
import com.vasy.resttemplate.entities.Employee;
import com.vasy.resttemplate.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	private EmployeeDTO toEmployeeDTO(Employee employee) {
		ModelMapper mapper= new ModelMapper();
		return mapper.map(employee, EmployeeDTO.class);
	}
	private Employee toEmployee(EmployeeDTO employeeDTO) {
		ModelMapper mapper= new ModelMapper();
		return mapper.map(employeeDTO, Employee.class);
	}


	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees= employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = employees.stream().map(this::toEmployeeDTO).toList();
		return employeeDTOs;
	}

	@Override
	public EmployeeDTO getEmployeeById(int id) {
		Employee employee= employeeRepository.findById(id).get();
		return toEmployeeDTO(employee);
	}

	@Override
	public void saveOrUpdate(EmployeeDTO employeeDTO) {
		Employee employee= toEmployee(employeeDTO);
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);;
	}

}
