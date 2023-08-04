package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.example.demo.dto.ScheduleDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "schedule")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "day", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date day;
	
	@Column(name = "startAt", nullable = false)
	private Time startAt;
	
	@Column(name = "finishAt", nullable = false)
	private Time finishAt;
	
	@ManyToOne
	@JoinColumn(name = "doctorId", referencedColumnName = "id")
	private Doctor doctor;
	
	@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
	private List<Booking> listBooking;
	
	public ScheduleDTO toDTO() {
		ScheduleDTO p = new ScheduleDTO();
		p.setId(id);
		p.setDay(day);
		p.setStartAt(startAt);
		p.setFinishAt(finishAt);
		p.setDoctorDTO(doctor.toDTO());
		return p;
	}
}
