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
@RequestMapping("/api/v1/employee/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/company-details/{employeeId}")
    public ResponseEntity<?> getCompanyDetailsOfEmployee(final @PathVariable("employeeId") String employeeId) {
        return employeeService.getCompanyDetailsOfEmployee(employeeId);
    }
}
