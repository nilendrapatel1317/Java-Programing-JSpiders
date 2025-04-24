package com.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.models.Appointment;
import com.spring.services.AppointmentService;
import com.spring.services.DoctorService;
import com.spring.services.PatientService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;

	// Open All Appointment
	@GetMapping
	public String getAllAppointments(Model model) {
		List<Appointment> appointments = appointmentService.getAllAppointment();
		model.addAttribute("appointments", appointments);
		return "appointment/appointments-list";
	}

	// Open Add Appointment Form
	@GetMapping("/add")
	public String showAddAppointmentForm(Model model) {
		model.addAttribute("appointment", new Appointment());
		model.addAttribute("doctors", doctorService.getAllDoctors());
		model.addAttribute("patients", patientService.getAllPatients());
		return "appointment/appointment-add";
	}

	// Submit Add Appointment Form
	@PostMapping("/add")
	public String addAppointment(@ModelAttribute Appointment appointment) {
		appointmentService.addAppointment(appointment);
		return "redirect:/appointment";
	}
	
	// Open Edit Appointment Form
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {

		Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
		if (appointment.isPresent()) {
			model.addAttribute("appointment", appointment.get()); // not Optional
    		model.addAttribute("doctors", doctorService.getAllDoctors());
    		model.addAttribute("patients", patientService.getAllPatients());
            return "appointment/appointment-edit"; 
        } else {
            return "redirect:/appointment";
        }
	}

	// Submit Edit Appointment
	@PostMapping("/edit/{id}")
	public String updateAppointment(@PathVariable Long id, @ModelAttribute Appointment appointment) {
		appointmentService.updateAppointment(id, appointment);
		return "redirect:/appointment";
	}

	// Delete Appointment
	@GetMapping("/delete/{id}")
	public String deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointment(id);
		return "redirect:/appointment";
	}
	
	@GetMapping("/find/{id}")
	public Optional<Appointment> getAppointmentsById(@PathVariable Long id) {
		return appointmentService.getAppointmentById(id);
	}


	@DeleteMapping("/deleteAll")
	public String deleteAllAppointment() {
		return appointmentService.deleteAllAppointment();
	}

}
