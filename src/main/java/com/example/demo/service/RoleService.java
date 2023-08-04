package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Role;

public interface RoleService {
	public List<Role> getAll();
	public Role getById(Integer id);
	public Role getByTitle(String title);
	public Role saveRole(Role role);
	public boolean deleteRole(Integer id);
}
