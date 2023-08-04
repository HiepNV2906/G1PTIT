package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Schedule;

public interface ScheduleService {
	public List<ScheduleDTO> getScheduleByDoctorId(Integer id);
	public Schedule getScheduleById(Integer id);
	public Schedule saveSchedule(Schedule schedule);
	public boolean deleteScheduleById(Integer id);
}
