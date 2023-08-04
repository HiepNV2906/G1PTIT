package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Department;
import com.example.demo.model.Doctor;
import com.example.demo.model.Role;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.RoleService;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	RoleService roleService;
	
	@PostMapping(value="/", produces = "application/json")
	public DoctorDTO addDoctor(@RequestBody DoctorDTO doctorDto) {
		Doctor d = doctorDto.toModel();
		d.setUsername(doctorDto.getEmail());
		d.setPassword(doctorDto.getPhone());
		Department department = departmentService.getDepartmentById(doctorDto.getDepartmentDTO().getId());
		d.setDepartment(department);
		Set<Role> roles = new HashSet<>();
		roles.add(roleService.getByTitle("DOCTOR"));
		d.setRoles(roles);
		return doctorService.saveDoctor(d).toDTO();
	}
	
	@GetMapping(value="/{id}", produces = "application/json")
	public DoctorDTO getDoctorById(@PathVariable("id") Integer id) {
		return doctorService.getDoctorById(id).toDTO();
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public boolean deleteDoctorById(@PathVariable("id") Integer id){
		return doctorService.deleteDoctor(id);
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	public DoctorDTO editDoctor(@RequestBody DoctorDTO doctorDto) {
		Doctor d = doctorDto.toModel();
		Department department = departmentService.getDepartmentById(doctorDto.getDepartmentDTO().getId());
		d.setDepartment(department);
		return doctorService.saveDoctor(d).toDTO();
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<DoctorDTO> getListDoctor(){
		return doctorService.getAll();
	}
	
	@GetMapping(value = "/listSchedules/{id}", produces = "application/json")
	public List<ScheduleDTO> getListScheduleByDoctorId(@PathVariable("id") Integer doctorId){
		return scheduleService.getScheduleByDoctorId(doctorId);
	}
}
