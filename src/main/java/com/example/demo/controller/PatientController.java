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

import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Patient;
import com.example.demo.model.Role;
import com.example.demo.service.PatientService;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	PatientService patientService;
	@Autowired
	RoleService roleService;
	
	@PostMapping(value = "/", produces = "application/json")
	public PatientDTO addPatient(@RequestBody Patient patient) {
		Set<Role> roles = new HashSet<>();
		roles.add(roleService.getByTitle("PATIENT"));
		patient.setRoles(roles);
		patient.setUsername(patient.getEmail());
		return patientService.savePatient(patient).toDTO();
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public PatientDTO getPatientById(@PathVariable("id") Integer id) {
		return patientService.getPatientById(id).toDTO();
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<PatientDTO> getListPatient(){
		return patientService.getAll();
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public boolean deletePatientById(@PathVariable("id") Integer id) {
		return patientService.deletePatientById(id);
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	public PatientDTO editPatient(@RequestBody PatientDTO patientdto) {
		Patient p = patientdto.toModel();
		return patientService.savePatient(p).toDTO();
	}
}
