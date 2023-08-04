package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.model.Department;

public interface DepartmentService {
	public Department getDepartmentById(Integer id);
	public Department saveDepartment(Department d);
	public boolean deleteDepartmentById(Integer id);
	public List<DepartmentDTO> getAll();
}
