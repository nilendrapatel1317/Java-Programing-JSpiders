package com.spring.mapping;

import com.spring.DAO.PatientDAO;
import com.spring.DTO.PatientDTO;
import com.spring.models.Patient;

public class Mapping {
	public static Patient convertDTOtoPatient(PatientDTO dto) {
		return new Patient(dto.getId(), dto.getName(), dto.getGender(), dto.getAge());
	}
	
	public static PatientDAO convertPatientToDAO(Patient patient) {
		return new PatientDAO(patient.getId(), patient.getName(), patient.getGender());
	}
}
