package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorRepository doctorRepository;
	
	public Doctor getDoctorById(Integer  id) {
		return doctorRepository.getById(id);
	}

	@Override
	public List<DoctorDTO> getDoctorByDepartment(Integer  departmentId) {
		List<Doctor> doctors = doctorRepository.findByDepartmentId(departmentId);
		List<DoctorDTO> doctorDTOs = doctors.stream().map(d -> d.toDTO()).collect(Collectors.toList());
		return doctorDTOs;
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		Doctor d = doctorRepository.save(doctor);
		return d;
	}

	@Override
	public boolean deleteDoctor(Integer id) {
		doctorRepository.deleteById(id);
		return false;
	}

	@Override
	public List<DoctorDTO> getAll() {
		List<Doctor> list = doctorRepository.findAll();
		List<DoctorDTO> listDto = list.stream().map(d -> d.toDTO()).collect(Collectors.toList());
		return listDto;
	}
	
	
}
