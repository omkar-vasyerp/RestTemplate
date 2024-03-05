package com.vasy.resttemplate.controller;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.vasy.resttemplate.dto.EmployeeDTO;
import com.vasy.resttemplate.entities.Employee;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    private final String URI_EMPLOYEE = "http://localhost:8080/employees";


    private final RestTemplate restTemplate;

    @GetMapping("/employees")
    public ResponseEntity getAllEmployee() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.GET, entity, EmployeeDTO[].class);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployeeById(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE+"/"+id, HttpMethod.GET, entity, EmployeeDTO.class);
    }

     @PostMapping("/employees")
    public ResponseEntity createEmployee(@RequestBody final Employee newEmployee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity < Employee > entity = new HttpEntity < > (newEmployee, httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE, HttpMethod.POST, entity, Employee.class);
    }

     @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable final int id, @RequestBody Employee newEmployee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity < Employee > entity = new HttpEntity < > (newEmployee, httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE + "/"+id, HttpMethod.PUT, entity, Employee.class);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity < Employee > delete(@PathVariable final int id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity < Employee > entity = new HttpEntity < > (httpHeaders);
        return restTemplate.exchange(URI_EMPLOYEE +"/"+ id, HttpMethod.DELETE, entity, Employee.class);
    }
}
