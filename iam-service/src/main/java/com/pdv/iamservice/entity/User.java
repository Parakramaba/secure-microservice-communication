package com.pdv.iamservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 254, unique = true)
    private String userName;

    // Could mask the sensitive data in logs using appropriate logging framework
    @Column(nullable = false, length = 254)
    @ToString.Exclude
    private String password;

    @Column(columnDefinition = "boolean not null default true")
    private Boolean isActive =  Boolean.TRUE;

    @Column(length = 254, nullable = false)
    @JsonIgnoreProperties("users")
    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;
}
