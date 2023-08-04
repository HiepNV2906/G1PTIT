package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public Patient getPatientById(Integer id) {
		return patientRepository.getById(id);
	}

	@Override
	public Patient savePatient(Patient p) {
		Patient patient = patientRepository.save(p);
		return patient;
	}

	@Override
	public boolean deletePatientById(Integer id) {
		patientRepository.deleteById(id);
		return false;
	}

	@Override
	public List<PatientDTO> getAll() {
		List<Patient> list = patientRepository.findAll();
		List<PatientDTO> listDTO = list.stream().map(d -> d.toDTO()).collect(Collectors.toList());
		return listDTO;
	}

}
