package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Doctor;

public interface DoctorService {
	public Doctor getDoctorById(Integer id);
	public List<DoctorDTO> getDoctorByDepartment(Integer departmentId);
	public Doctor saveDoctor(Doctor doctor);
	public boolean deleteDoctor (Integer id);
	public List<DoctorDTO> getAll();
}
