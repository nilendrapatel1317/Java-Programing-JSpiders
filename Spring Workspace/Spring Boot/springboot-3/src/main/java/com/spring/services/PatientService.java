package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.DAO.PatientDAO;
import com.spring.DTO.PatientDTO;
import com.spring.models.Patient;
import com.spring.repositories.PatientRepository;

public interface PatientService {

	// Find all Patients
	public List<PatientDAO> getAllPatients() ;
	public List<Patient> getAllPatientsBySort(String sortBy) ;

	//Find Patient By Id
	public PatientDAO getPatientById(String id) ;
	public List<Patient> getPatientByAge(int age) ;
	public List<Patient> getPatientByAge(int age, String name) ;
	
	//Add Patient
	public PatientDAO addPatient(PatientDTO patientDTO) ;

	
	//Update Patient
	public Patient updatePatient(String id, Patient updatedPatient) ;

	// Delete Patient
	public String deletePatient(String id);

	public String deleteAllPatient();
	

}
