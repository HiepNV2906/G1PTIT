package com.example.demo.model;

import java.sql.Date;
import java.util.Set;

import com.example.demo.dto.PersonDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "person")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	protected Integer id;
	
	@Column(name = "name", length = 255, nullable = false)
	protected String name;
	
	@Column(name = "dateOfBirth", nullable = false)
	@Temporal(TemporalType.DATE)
	protected Date dateOfBirth;
	
	@Column(name = "gender")
	protected boolean gender;
	
	@Column(name = "address", length = 255)
	protected String address;
	
	@Column(name = "phone", nullable = false)
	protected String phone;
	
	@Column(name = "email", nullable = false)
	protected String email;
	
	@Column(name = "username", nullable = false, unique = true)
	protected String username;
	
	@Column(name = "password", nullable = false)
	protected String password;
	
	@ManyToMany
	@JoinTable( name = "person_role", 
				joinColumns = @JoinColumn(columnDefinition = "personId"),
				inverseJoinColumns = @JoinColumn(columnDefinition = "roleId"))
	protected Set<Role> roles;
	
}
