package com.pdv.iamservice.repository;

import com.pdv.iamservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    /**
     * Returns a Role that have the given name.
     * @param name name of the role, not null
     * @return the role details, can be null
     */
    Optional<Role> findByName(String name);
}
