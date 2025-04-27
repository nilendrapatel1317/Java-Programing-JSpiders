package com.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.DTO.AppointmentDTO;
import com.spring.models.Appointment;

public interface AppointmentService {

	public List<Appointment> getAllAppointment();

	public List<Appointment> getAllAppointmentsSortBy(String sortBy);
	
	Optional<Appointment> getAppointmentById(String id);

	public Appointment addAppointment(Appointment appointment);
	
	//For Security, structure, maintainability
	public AppointmentDTO addAppointmentDTO(Appointment appointment);


	public Appointment updateAppointmentDate(String id, Appointment appointment);
	public Appointment updateAppointmentStatus(String id, Appointment appointment);

	public String deleteAppointment(String id);
	
	public String deleteAllAppointment();

}
