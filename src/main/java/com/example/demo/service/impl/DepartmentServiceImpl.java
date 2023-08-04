package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public Department getDepartmentById(Integer id) {
		return departmentRepository.getById(id);
	}

	@Override
	public Department saveDepartment(Department d) {
		return departmentRepository.save(d);
	}

	@Override
	public boolean deleteDepartmentById(Integer id) {
		departmentRepository.deleteById(id);
		return false;
	}

	@Override
	public List<DepartmentDTO> getAll() {
		List<Department> list = departmentRepository.findAll();
		List<DepartmentDTO> listDto = list.stream().map(d -> d.toDTO()).collect(Collectors.toList());
		return listDto;
	}

}
