package com.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.DTO.AppointmentDTO;
import com.spring.models.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	AppointmentDTO save(AppointmentDTO appointmentDTO);
}
