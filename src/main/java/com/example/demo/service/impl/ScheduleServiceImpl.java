package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ScheduleDTO;
import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	ScheduleRepository scheduleRepository;

	@Override
	public List<ScheduleDTO> getScheduleByDoctorId(Integer id) {
		List<Schedule> list = scheduleRepository.findByDoctorId(id);
		List<ScheduleDTO> listDTO = list.stream().map(d -> d.toDTO()).collect(Collectors.toList());
		return listDTO;
	}

	@Override
	public Schedule getScheduleById(Integer id) {
		return scheduleRepository.getById(id);
	}

	@Override
	public Schedule saveSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public boolean deleteScheduleById(Integer id) {
		scheduleRepository.deleteById(id);
		return false;
	}

}
