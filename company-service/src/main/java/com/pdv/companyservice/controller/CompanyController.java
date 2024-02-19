package com.pdv.companyservice.controller;


import com.pdv.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller class provide set of API endpoints, which are using to handle companies.
 */
@RestController
@RequestMapping("/api/v1/company/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<?> getCompany(final @PathVariable("companyId") Long companyId) {
        return companyService.getCompany(companyId);
    }

    @GetMapping("/by-name/{companyName}")
    public ResponseEntity<?> getCompanyByName(final @PathVariable("companyName") String companyName) {
        return companyService.getCompanyByName(companyName);
    }
}
