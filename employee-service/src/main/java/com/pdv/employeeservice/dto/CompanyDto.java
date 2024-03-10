package com.pdv.employeeservice.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CompanyDto implements Serializable {

    private Long id;
    private String name;
    private Integer noOfEmployees;
}
