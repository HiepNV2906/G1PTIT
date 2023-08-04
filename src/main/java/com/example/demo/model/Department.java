package com.example.demo.model;

import java.util.List;

import com.example.demo.dto.DepartmentDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "department")
public class Department{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer ID;
	
	@Column(name = "name", length = 255, nullable = false)
	private String name;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Doctor> listDoctors;
	
	public DepartmentDTO toDTO() {
		DepartmentDTO p = new DepartmentDTO();
		p.setId(ID);
		p.setName(name);
		p.setPhone(phone);
		p.setDescription(description);
		return p;
	}
}
