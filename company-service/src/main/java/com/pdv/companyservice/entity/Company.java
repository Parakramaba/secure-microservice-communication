package com.pdv.companyservice.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Company implements Serializable {

    private Long id;
    private String name;
    private Integer noOfEmployees;

}
