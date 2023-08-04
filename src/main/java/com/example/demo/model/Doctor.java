package com.example.demo.model;

import java.util.List;

import com.example.demo.dto.DoctorDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "doctor")
public class Doctor extends Person{

	@Column(name = "experience")
	private int experience;
	
	@Column(name = "degree")
	@Enumerated(EnumType.STRING)
	private Degree degree;
	
	@ManyToOne
	@JoinColumn(name = "departmentId", referencedColumnName = "id")
	private Department department;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<Schedule> listSchedule;
	
	public DoctorDTO toDTO() {
		DoctorDTO p = new DoctorDTO();
		p.setId(this.getId());
		p.setName(this.getName());
		p.setDateOfBirth(this.getDateOfBirth());
		p.setGender(this.isGender());
		p.setAddress(this.getAddress());
		p.setPhone(this.getPhone());
		p.setExperience(experience);
		p.setDegree(degree.toString());
		p.setDepartmentDTO(department.toDTO());
		return p;
	}
}
