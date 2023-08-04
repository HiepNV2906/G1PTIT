package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Booking;

public interface BookingService {
	public Booking getBookingById(Integer id);
	public List<Booking> getAll();
	public Booking saveBooking(Booking booking);
	public boolean deleteBooking(Integer id);
	public Booking changeStatusOfBooking(Integer bookingId, String status);
	public List<Booking> getBookingByScheduleId(Integer scheduleId);
	public List<Booking> getBookingByPatientId(Integer patientId);
}
