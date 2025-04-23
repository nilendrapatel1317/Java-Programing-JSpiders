package com.spring.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.DTO.AppointmentDTO;
import com.spring.models.Appointment;
import com.spring.services.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping
	public List<AppointmentDTO> getAllAppointments() {
	    List<Appointment> appointments = appointmentService.getAllAppointment();
	    return appointments.stream()
	            .map(this::addAppointment)
	            .collect(Collectors.toList());
	}

	
	@PostMapping
	public AppointmentDTO addAppointment(@RequestBody Appointment appointment) {
		return appointmentService.addAppointment(appointment);
	}
	
}
