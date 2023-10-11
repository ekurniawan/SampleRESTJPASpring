package com.actualtraining.samplerestjpa.repository;


import com.actualtraining.samplerestjpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
