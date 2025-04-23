package com.spring.serviceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.models.Patient;
import com.spring.repositories.PatientRepository;
import com.spring.services.PatientService;

@Service
public class PatientServiceImplementation implements PatientService {
	@Autowired
	private PatientRepository patientRepository;

	// Find all Patients
	@Override
	public List<Patient> getAllPatients() {
		try {
			return patientRepository.findAll(Sort.by("id").ascending());
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return null;
		}
	}

	// Find Patient By Id
	@Override
	public Optional<Patient> getPatientById(Long id) {
		try {
			return patientRepository.findById(id);
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Patient> getPatientByAge(int age) {
		try {
			return patientRepository.findByAge(age);
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Patient> getPatientByAge(int age, String name) {
		try {
			return patientRepository.findByAgeAndName(age, name);
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return null;
		}
	}

	// Add Patient
	@Override
	public Patient addPatient(Patient patient) {
		try {
			return patientRepository.save(patient);
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return null;
		}
	}

	// Update Patient
	@Override
	public Patient updatePatient(Long id, Patient updatedPatient) {
		try {
			Patient existing = patientRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Patient not found"));

			// Update whatever you want to update
			existing.setName(updatedPatient.getName());
			existing.setAge(updatedPatient.getAge());
			existing.setGender(updatedPatient.getGender());

			return patientRepository.save(existing);
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return null;
		}
	}

	// Delete Patient
	@Override
	public String deletePatient(Long id) {
		try {
			if (patientRepository.existsById(id)) {
				patientRepository.deleteById(id);
				return "Patient Deleted Successfully !!";
			} else {
				return "Patient not found !!";
			}
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return e.getMessage();
		}
	}

	@Override
	public String deleteAllPatient() {
		try {
			patientRepository.deleteAll();
			;
			return "All Patients Deleted Successfully !!";
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
			return e.getMessage();
		}
	}

}
