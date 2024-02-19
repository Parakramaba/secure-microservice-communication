package com.pdv.companyservice.service;


import com.pdv.companyservice.entity.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * This service class implements the business logic of endpoints, which are using to handle companies.
 */
@Service("CompanyService")
public class CompanyService {

    /**
     * Returns all companies.
     * @return ResponseEntity with all companies
     */
    public ResponseEntity<?> getAllCompanies() {
        List<Company> companies = LongStream.rangeClosed(1, 5)
                .mapToObj(i -> new Company(i, "Company " + i, 10))
                .collect(Collectors.toList());

        return ResponseEntity.ok(companies);
    }

    /**
     * Returns the company by ID.
     * @param companyId ID of the company, not null
     * @return ResponseEntity with company
     */
    public ResponseEntity<?> getCompany(final Long companyId) {
        Company company = Company.builder()
                .id(companyId)
                .name("Company " + companyId)
                .noOfEmployees(50)
                .build();

        return ResponseEntity.ok(company);
    }

    /**
     * Returns the company of specific name.
     * @param companyName Name of the company, not null
     * @return ResponseEntity with company
     */
    public ResponseEntity<?> getCompanyByName(final String companyName) {
        Company company = Company.builder()
                .id(15L)
                .name(companyName)
                .noOfEmployees(75)
                .build();

        return ResponseEntity.ok(company);
    }
}
