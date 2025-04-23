package com.spring.services;

import java.util.List;

import com.spring.DTO.AppointmentDTO;
import com.spring.models.Appointment;

public interface AppointmentService {

	public List<Appointment> getAllAppointment();

	public AppointmentDTO addAppointment(Appointment appointment);

}
