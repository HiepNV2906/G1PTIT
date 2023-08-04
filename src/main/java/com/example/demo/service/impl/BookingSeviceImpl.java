package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.Status;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;

@Service
public class BookingSeviceImpl implements BookingService{

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public Booking getBookingById(Integer id) {
		return bookingRepository.getById(id);
	}

	@Override
	public List<Booking> getAll() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public boolean deleteBooking(Integer id) {
		bookingRepository.deleteById(id);
		return false;
	}

	@Override
	public Booking changeStatusOfBooking(Integer bookingId, String status) {
		Booking booking = bookingRepository.getById(bookingId);
		booking.setStatus(Status.valueOf(status));
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getBookingByScheduleId(Integer scheduleId) {
		return bookingRepository.findByScheduleId(scheduleId);
	}

	@Override
	public List<Booking> getBookingByPatientId(Integer patientId) {
		return bookingRepository.findByPatientId(patientId);
	}

}
