package com.pdv.employeeservice.service;


import com.pdv.employeeservice.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * This service class implements the business logic of endpoints, which are using to handle employees.
 */
@Service("EmployeeService")
public class EmployeeService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    /**
     * Returns the current working company details of an employee.
     * @param employeeId ID of the employee, not null
     * @return ResponseEntity with company
     */
    public ResponseEntity<?> getCurrentWorkingCompanyOfEmployee(final String employeeId) {

        // TODO: restructure when integrate the database
         Long employeeCurrentWorkingCompanyId = 1L;

        // This is just using for representing the external calling to another service.
        CompanyDto currentCompany = webClientBuilder.build()
                .get()
                .uri("http://company-service/api/v1/company/companies/{companyId}", employeeCurrentWorkingCompanyId)
                .retrieve()
                .bodyToMono(CompanyDto.class)
                .block();

        return new ResponseEntity<>(currentCompany, HttpStatus.OK);
    }
}
