package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Doctor;
import com.example.demo.model.Schedule;
import com.example.demo.service.DoctorService;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	DoctorService doctorService;
	
	@PostMapping(value = "/", produces = "application/json")
	public ScheduleDTO addSchedule(@RequestBody ScheduleDTO scheduleDTO) {
		Schedule schedule = scheduleDTO.toModel();
		Doctor doctor = doctorService.getDoctorById(scheduleDTO.getDoctorDTO().getId());
		schedule.setDoctor(doctor);
		return scheduleService.saveSchedule(schedule).toDTO();
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	public ScheduleDTO editSchedule(@RequestBody ScheduleDTO scheduleDTO) {
		Schedule schedule = scheduleDTO.toModel();
		Doctor doctor = doctorService.getDoctorById(scheduleDTO.getDoctorDTO().getId());
		schedule.setDoctor(doctor);
		return scheduleService.saveSchedule(schedule).toDTO();
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public boolean deleteSchedule(@PathVariable("id") Integer id) {
		return scheduleService.deleteScheduleById(id);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ScheduleDTO getScheduleById(@PathVariable("id") Integer id) {
		return scheduleService.getScheduleById(id).toDTO();
	}
}
