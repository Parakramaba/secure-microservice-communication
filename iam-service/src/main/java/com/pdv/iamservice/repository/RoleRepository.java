package com.pdv.iamservice.repository;

import com.pdv.iamservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
