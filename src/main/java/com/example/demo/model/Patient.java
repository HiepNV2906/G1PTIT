package com.example.demo.model;

import java.util.List;

import com.example.demo.dto.PatientDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "patient")
public class Patient extends Person{

	@Column(name = "idInsurance")
	private String idInsurance;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Booking> listBooking;
	
	public PatientDTO toDTO() {
		PatientDTO p = new PatientDTO();
		p.setId(this.getId());
		p.setName(this.getName());
		p.setDateOfBirth(this.getDateOfBirth());
		p.setGender(this.isGender());
		p.setAddress(this.getAddress());
		p.setPhone(this.getPhone());
		p.setEmail(this.getEmail());
		p.setIdInsurance(idInsurance);
		return p;
	}
}
