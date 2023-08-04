package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	DoctorService doctorService;
	
	@PostMapping(value = "/", produces = "application/json")
	public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
		Department d = departmentDTO.toModel();
		return departmentService.saveDepartment(d).toDTO();
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	public DepartmentDTO editDepartment(@RequestBody DepartmentDTO departmentDTO) {
		Department d = departmentDTO.toModel();
		return departmentService.saveDepartment(d).toDTO();
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public DepartmentDTO getDepartmentById(@PathVariable("id") Integer id) {
		return departmentService.getDepartmentById(id).toDTO();
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public boolean deleteDepartmentById(@PathVariable("id") Integer id) {
		return departmentService.deleteDepartmentById(id);
	}
	
	@GetMapping(value = "/listDoctors/{id}", produces = "application/json")
	public List<DoctorDTO> getListDoctorsByDepartment(@PathVariable("id") Integer id){
		return doctorService.getDoctorByDepartment(id);
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<DepartmentDTO> getListDepartment(){
		return departmentService.getAll();
	}

}
