package com.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.models.Appointment;
import com.spring.services.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping("/findAll")
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointment();
	}

	@GetMapping("/find/{id}")
	public Optional<Appointment> getAppointmentsById(@PathVariable Long id) {
		return appointmentService.getAppointmentById(id);
	}
	
	@PostMapping("/add")
	public Appointment addAppointment(@RequestBody Appointment appointment) {
		return appointmentService.addAppointment(appointment);
	}
	
	@PutMapping("/edit/{id}")
	public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		
		return appointmentService.updateAppointment(id,appointment);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAppointment(@PathVariable Long id) {
		return appointmentService.deleteAppointment(id);
	}

	@DeleteMapping("/deleteAll")
	public String deleteAllAppointment() {
		return appointmentService.deleteAllAppointment();
	}
	
}
