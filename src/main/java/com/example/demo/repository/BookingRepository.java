package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	@Query(value = "SELECT * FROM booking WHERE schedule_id=?1", nativeQuery = true)
	public List<Booking> findByScheduleId(Integer scheduleId);
	
	@Query(value = "SELECT * FROM booking WHERE patient_id=?1", nativeQuery = true)
	public List<Booking> findByPatientId(Integer patientId);
}
