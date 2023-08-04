package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Patient;

public interface PatientService {
	public Patient getPatientById(Integer id);
	public Patient savePatient(Patient p);
	public boolean deletePatientById(Integer id);
	public List<PatientDTO> getAll();
}
