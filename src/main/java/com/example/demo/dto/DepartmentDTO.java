package com.example.demo.dto;

import com.example.demo.model.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
	private Integer id;
	private String name;
	private String phone;
	private String description;
	
	public Department toModel() {
		Department p = new Department();
		p.setID(id);
		p.setName(name);
		p.setPhone(phone);
		p.setDescription(description);
		return p;
	}
}
