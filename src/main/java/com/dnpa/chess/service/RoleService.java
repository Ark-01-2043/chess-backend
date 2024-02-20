package com.dnpa.chess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dnpa.chess.entity.Role;
import com.dnpa.chess.repository.RoleRepository;

public interface RoleService {
	public List<Role> getAll();
	public Role getRoleById(int id);
	public void deleteById(int id);
	public void addRole(Role role);
}
