package com.example.demo.model;

import java.sql.Time;

import com.example.demo.dto.BookingDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "booking")
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"scheduleId", "patientId"})})
public class Booking{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "time", nullable = false)
	private Time time;
	
	@Column(name = "bookingAt", nullable = false)
	private Time bookingAt;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "patientId", referencedColumnName = "id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "scheduleId", referencedColumnName = "id")
	private Schedule schedule;

	public BookingDTO toDTO() {
		BookingDTO p = new BookingDTO();
		p.setId(id);
		p.setTime(time);
		p.setBookingAt(bookingAt);
		p.setStatus(status.toString());
		p.setPatientDTO(patient.toDTO());
		p.setScheduleDTO(schedule.toDTO());;
		return p;
	}
}
