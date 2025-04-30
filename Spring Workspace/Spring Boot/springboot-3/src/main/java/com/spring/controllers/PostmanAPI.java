package com.spring.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spring.DAO.PatientDAO;
import com.spring.DTO.PatientDTO;
import com.spring.models.Patient;
import com.spring.services.PatientService;
import com.spring.structures.ResponseStructure;

@RestController
@RequestMapping("/patients")

public class PostmanAPI {

	@Autowired
	private PatientService patientService;

	@GetMapping
	public ResponseEntity<ResponseStructure<List<PatientDAO>>> viewAllPatients() {
		List<PatientDAO> patients = patientService.getAllPatients();

		ResponseStructure<List<PatientDAO>> response = new ResponseStructure<>();

		if (patients != null && !patients.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMsg("Patients fetched successfully");
			response.setData(patients);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("No patients found");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add")
	public ResponseStructure<PatientDAO> addPatient(@RequestBody PatientDTO patientDTO) {
		PatientDAO patient1 = patientService.addPatient(patientDTO);
		if (patient1 != null) {
			return new ResponseStructure<>("success", 200, patient1);
		} else {
			return new ResponseStructure<>("failed", 404, patient1);
		}
	}

	@PostMapping("/delete")
	public ResponseEntity<String> deletePatient(@RequestBody Map<String, String> payload) {
		String id = payload.get("id");
		patientService.deletePatient(id);
		return ResponseEntity.ok("Patient deleted");
	}
	
	@GetMapping("/{id}")
	public PatientDAO findById(@PathVariable String id) {
		return patientService.getPatientById(id);
	}

}
