package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingDTO;
import com.example.demo.model.Booking;
import com.example.demo.model.Patient;
import com.example.demo.model.Schedule;
import com.example.demo.model.Status;
import com.example.demo.service.BookingService;
import com.example.demo.service.PatientService;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;
	@Autowired
	PatientService patientService;
	@Autowired
	ScheduleService scheduleService;
	
	@PostMapping(value = "/", produces = "application/json")
	public BookingDTO addBooking(@RequestBody BookingDTO bookingDTO) {
		Booking booking = bookingDTO.toModel();
		Patient patient =  patientService.getPatientById(bookingDTO.getPatientDTO().getId());
		Schedule schedule = scheduleService.getScheduleById(bookingDTO.getScheduleDTO().getId());
		booking.setPatient(patient);
		booking.setSchedule(schedule);
		booking.setStatus(Status.PENDING);
		return bookingService.saveBooking(booking).toDTO();
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	public BookingDTO editBooking(@RequestBody BookingDTO bookingDTO) {
		Booking booking = bookingDTO.toModel();
		Patient patient =  patientService.getPatientById(bookingDTO.getPatientDTO().getId());
		Schedule schedule = scheduleService.getScheduleById(bookingDTO.getScheduleDTO().getId());
		booking.setPatient(patient);
		booking.setSchedule(schedule);
		return bookingService.saveBooking(booking).toDTO();
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public BookingDTO getBookingById(@PathVariable("id") Integer bookingId) {
		return bookingService.getBookingById(bookingId).toDTO();
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public boolean deleteBookingById(@PathVariable("id") Integer bookingId) {
		return bookingService.deleteBooking(bookingId);
	}
	
	@GetMapping(value = "/list", produces = "application/json")
	public List<BookingDTO> getAllBooking() {
		return bookingService.getAll().stream().map(d -> d.toDTO()).collect(Collectors.toList());
	}
	
	@GetMapping(value = "/bySchedule/{id}", produces = "application/json")
	public List<BookingDTO> getBookingByScheduleId(@PathVariable("id") Integer scheduleId) {
		return bookingService.getBookingByScheduleId(scheduleId).stream().map(d -> d.toDTO()).collect(Collectors.toList());
	}
	
	@GetMapping(value = "/byPatient/{id}", produces = "application/json")
	public List<BookingDTO> getBookingByPatientId(@PathVariable("id") Integer patientId) {
		return bookingService.getBookingByPatientId(patientId).stream().map(d -> d.toDTO()).collect(Collectors.toList());
	}
	
	@PutMapping(value = "/changeStatus/{id}", produces = "application/json")
	public BookingDTO changeStatusOfBooking(@PathVariable("id") Integer bookingId, @RequestBody String status) {
		Booking booking = bookingService.getBookingById(bookingId);
		booking.setStatus(Status.valueOf(status));
		return bookingService.saveBooking(booking).toDTO();
	}
}
