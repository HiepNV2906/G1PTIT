package com.example.demo.dto;

import java.sql.Date;
import java.sql.Time;

import com.example.demo.model.Schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
	private Integer id;
	private Date day;
	private Time startAt;
	private Time finishAt;
	private DoctorDTO doctorDTO;
	
	public Schedule toModel() {
		Schedule p = new Schedule();
		p.setId(id);
		p.setDay(day);
		p.setStartAt(startAt);
		p.setFinishAt(finishAt);
		return p;
	}
}
