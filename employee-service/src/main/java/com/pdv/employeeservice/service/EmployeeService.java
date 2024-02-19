package com.pdv.employeeservice.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * This service class implements the business logic of endpoints, which are using to handle employees.
 */
@Service("EmployeeService")
public class EmployeeService {

    /**
     * Returns the current working company details of an employee.
     * @param employeeId ID of the employee, not null
     * @return ResponseEntity with company
     */
    public ResponseEntity<?> getCompanyDetailsOfEmployee(final String employeeId) {

        // This is just using for representing the external calling to another service.
        // Should follow the best practice when we choose the domain of a specific API.
        // TODO: call to CompanyService

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
