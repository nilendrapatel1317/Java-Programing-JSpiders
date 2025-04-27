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

import com.spring.models.Doctor;
import com.spring.services.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	// Open All Doctors Page (View List) 
	@GetMapping
	public String viewAllDoctors(Model model) {
		List<Doctor> doctors = doctorService.getAllDoctors();
		model.addAttribute("doctors", doctors);
		return "doctor/doctors-list";
	}

	// Open Add Doctor Form
	@GetMapping("/add")
	public String addDoctorForm() {
		return "doctor/doctor-add";
	}

	// Submit Add Doctor Form 
	@PostMapping("/add")
	public String addDoctor(@ModelAttribute Doctor doctor) {
		doctorService.addDoctor(doctor);
		return "redirect:/doctor";
	}

	// Open Edit Doctor Form
	@GetMapping("/edit/{id}")
	public String editDoctorForm(@PathVariable String id, Model model) {
		Optional<Doctor> doctor = doctorService.getDoctorById(id);
		if (doctor.isPresent()) {
			model.addAttribute("doctor", doctor.get());
			return "doctor/doctor-edit"; // edit-doctor.html
		} else {
			return "redirect:/doctor";
		}
	}

	// Submit Edit Doctor Form 
	@PostMapping("/edit/{id}")
	public String updateDoctor(@PathVariable String id, @ModelAttribute Doctor doctor) {
		doctorService.updateDoctor(id, doctor);
		return "redirect:/doctor";
	}

	// Delete Doctor by ID
	@GetMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable String id) {
		doctorService.deleteDoctor(id);
		return "redirect:/doctor";
	}

	
	@GetMapping("/find/{id}")
	public Optional<Doctor> getDoctorById(@PathVariable String id) {
		return doctorService.getDoctorById(id);
	}

	@DeleteMapping("/deleteAll")
	public String deleteAllDoctor() {
		return doctorService.deleteAllDoctor();
	}
}
