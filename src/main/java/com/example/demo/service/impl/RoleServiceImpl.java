package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role getById(Integer id) {
		return roleRepository.getById(id);
	}

	@Override
	public Role getByTitle(String title) {
		return roleRepository.findByTitle(title);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public boolean deleteRole(Integer id) {
		roleRepository.deleteById(id);
		return false;
	}

}
