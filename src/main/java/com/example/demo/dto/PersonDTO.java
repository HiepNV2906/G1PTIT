package com.example.demo.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
	protected int id;
	protected String name;
	protected Date dateOfBirth;
	protected boolean gender;
	protected String address;
	protected String phone;
	@Email
	protected String email;
}
