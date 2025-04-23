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
import org.springframework.web.bind.annotation.RestController;

import com.spring.models.Patient;
import com.spring.repositories.DoctorRepository;
import com.spring.repositories.PatientRepository;
import com.spring.services.PatientService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/patient")
public class PatientController {


	@Autowired
	private PatientService patientService;

	// Fetch All Patient
	@GetMapping("/findAll")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}
	
	// Fetch Patient by Id
	@GetMapping("/find/{id}")
	public Optional<Patient> getPatientById(@PathVariable Long id) {
		return patientService.getPatientById(id);
	}

	//Custom Fetching
	@GetMapping("/age/{age}")
	public List<Patient> getPatientByAge(@PathVariable int age) {
		return patientService.getPatientByAge(age);
	}
	
	//Custom Fetching
	@GetMapping("/age/{age}/{name}")
	public List<Patient> getPatientByAge(@PathVariable int age , @PathVariable String name) {
		return patientService.getPatientByAge(age,name);
	}

	// Add Patient
	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	
	// Update Patient
	@PutMapping("/edit/{id}")
	public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
		return patientService.updatePatient(id,patient);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePatient(@PathVariable Long id) {
		return patientService.deletePatient(id);
	}
	@DeleteMapping("/deleteAll")
	public String deleteAllPatient() {
		return patientService.deleteAllPatient();
	}
	
}
