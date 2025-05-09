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

import com.spring.models.Doctor;
import com.spring.models.Patient;
import com.spring.repositories.DoctorRepository;
import com.spring.repositories.PatientRepository;
import com.spring.services.DoctorService;
import com.spring.services.PatientService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/findAll")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Doctor> getDoctorById(@PathVariable Long id){
		return doctorService.getDoctorById(id);
	}
	
	@PostMapping("/add")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
		
	}
	
	@PutMapping("/edit/{id}")
	public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
		return doctorService.updateDoctor(id, doctor);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable Long id) {
		return doctorService.deleteDoctor(id);
	}

	@DeleteMapping("/deleteAll")
	public String deleteAllDoctor() {
		return doctorService.deleteAllDoctor();
	}
}
