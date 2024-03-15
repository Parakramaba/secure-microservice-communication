package com.pdv.iamservice.repository;

import com.pdv.iamservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
