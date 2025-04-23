package com.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.DTO.AppointmentDTO;
import com.spring.models.Appointment;

public interface AppointmentService {

	public List<Appointment> getAllAppointment();

	public Appointment addAppointment(Appointment appointment);
	
	//For Security, structure, maintainability
	public AppointmentDTO addAppointmentDTO(Appointment appointment);

	public String deleteAppointment(Long id);

	public Appointment updateAppointment(Long id, Appointment appointment);

	public String deleteAllAppointment();

	public Optional<Appointment> getAppointmentById(Long id);

}
