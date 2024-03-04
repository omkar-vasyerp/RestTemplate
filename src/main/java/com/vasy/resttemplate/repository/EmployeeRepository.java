package com.vasy.resttemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasy.resttemplate.entities.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee	, Integer>{

}
