package com.dnpa.chess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dnpa.chess.entity.Role;
import com.dnpa.chess.entity.User;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	List<User> findByUsername(String username);
	List<User> findByEmail(String email);
	List<User> findByRole(Role role);
}
