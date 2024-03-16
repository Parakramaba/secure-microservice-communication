package com.pdv.employeeservice.controller;

import com.pdv.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller class provide set of API endpoints, which are using to handle employees.
 */
@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // This is a hypothetical API to represent the behavior of the front-end.
    // In actual case, we mostly call directly to the company service using the employees' current working company id.
    @GetMapping("/current-company/{employeeId}")
    public ResponseEntity<?> getCurrentWorkingCompanyOfEmployee(final @PathVariable("employeeId") String employeeId) {
        return employeeService.getCurrentWorkingCompanyOfEmployee(employeeId);
    }
}
