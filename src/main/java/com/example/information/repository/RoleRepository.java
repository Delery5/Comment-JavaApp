package com.example.information.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.information.entity.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(String name);

}
