package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Degree;
import com.example.demo.model.Doctor;
import com.example.demo.model.Role;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DoctorService;

@SpringBootTest
public class TestDoctorService {
	@Autowired
	DoctorService doctorService;
	@Autowired
	DepartmentRepository departmentRepository;
	
//	@Test
//	public void testGetDoctorById() {		
//		DoctorDTO d = doctorService.getDoctorById(1);
//		assertThat(d).isNull();
//	}
	
//	@Test
//	public void testSaveDoctor() {
//		Doctor d = new Doctor();
//		d.setName("Nguyễn Văn A");
//		d.setAddress("Hà Đông");
//		d.setDateOfBirth(Date.valueOf("15-06-2023"));
//		d.setEmail("abc120@gmail.com");
//		d.setDegree(Degree.BACHELOR);
//		d.setDepartment(departmentRepository.getById(1));
//		d.setExperience(5);
//		d.setPassword("123456");
//		d.setPhone("15445516");
//		d.setGender(true);
//		d.setUsername("abc120");
//		Set<Role> role = new HashSet<>();
//		role.
//		d.setRoles();
//	}
	
	@Test
	public void testFindDoctorByDepartmentId() {		
		List<DoctorDTO> d = doctorService.getDoctorByDepartment(1);
		assertThat(d).isNull();
	}
}
