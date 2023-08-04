package com.example.demo.dto;


import com.example.demo.model.Degree;
import com.example.demo.model.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO extends PersonDTO{
	private int experience;
	private String degree;
	private DepartmentDTO departmentDTO;
	
	public Doctor toModel() {
		Doctor p = new Doctor();
		p.setId(this.id);
		p.setName(this.name);
		p.setDateOfBirth(this.dateOfBirth);
		p.setGender(this.gender);
		p.setAddress(this.address);
		p.setPhone(this.phone);
		p.setEmail(this.email);
		p.setExperience(experience);
		p.setDegree(Degree.valueOf(degree));
		return p;
	}
}
