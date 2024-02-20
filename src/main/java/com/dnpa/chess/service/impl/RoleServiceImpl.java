package com.dnpa.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnpa.chess.entity.Role;
import com.dnpa.chess.repository.RoleRepository;
import com.dnpa.chess.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}
	
}
