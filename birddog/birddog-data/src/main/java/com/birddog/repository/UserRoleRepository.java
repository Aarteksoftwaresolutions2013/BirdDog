package com.birddog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
