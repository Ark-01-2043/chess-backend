package com.dnpa.chess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnpa.chess.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
