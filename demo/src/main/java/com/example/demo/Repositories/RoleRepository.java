package com.example.demo.Repositories;

import com.example.demo.Entities.ERole;
import com.example.demo.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}
