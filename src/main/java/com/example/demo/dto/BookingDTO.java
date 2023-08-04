package com.example.demo.dto;

import java.sql.Time;

import com.example.demo.model.Booking;
import com.example.demo.model.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
	private Integer id;
	private Time time;
	private Time bookingAt;
	private String status;
	private PatientDTO patientDTO;
	private ScheduleDTO scheduleDTO;
	
	public Booking toModel() {
		Booking p = new Booking();
		p.setId(id);
		p.setTime(time);
		p.setBookingAt(bookingAt);
		p.setStatus(Status.valueOf(status));
		return p;
	}
}
