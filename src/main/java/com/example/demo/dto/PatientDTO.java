package com.example.demo.dto;

import java.sql.Date;

import com.example.demo.model.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO extends PersonDTO{
	private String idInsurance;

	public Patient toModel() {
		Patient p = new Patient();
		p.setId(this.id);
		p.setName(this.name);
		p.setDateOfBirth(this.dateOfBirth);
		p.setGender(this.gender);
		p.setAddress(this.address);
		p.setPhone(this.phone);
		p.setEmail(this.email);
		p.setIdInsurance(idInsurance);
		return p;
	}
}
