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

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}
	@Override
	public Patient addPatient(Patient patient) {
		patient.setId(generateID());
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatientsBySort(String sortBy) {
		return patientRepository.findAll(Sort.by(sortBy));
	}

	@Override
	public Optional<Patient> getPatientById(String id) {
		return patientRepository.findById(id);
	}

	@Override
	public List<Patient> getPatientByAge(int age) {
		return patientRepository.findByAge(age);
	}

	@Override
	public List<Patient> getPatientByAge(int age, String name) {
		return patientRepository.findByAgeAndName(age, name);
	}


	private String generateID() {
		String lastIdStr = patientRepository.findLastId().orElse("PAT-100");
		int lastNum = Integer.parseInt(lastIdStr.split("-")[1]);
		String newId = "PAT-" + (lastNum + 1);
		return newId;
	}

	@Override
	public Patient updatePatient(String id, Patient updatedPatient) {
		Optional<Patient> optionalPatient = patientRepository.findById(id);
		if (optionalPatient.isPresent()) {
			// fetch old data
			Patient existingPatient = optionalPatient.get();

			// Update Whatever you want
			existingPatient.setName(updatedPatient.getName());
			existingPatient.setAge(updatedPatient.getAge());
			existingPatient.setGender(updatedPatient.getGender());

			return patientRepository.save(existingPatient);
		} else {
			throw new RuntimeException("Patient not found with id: " + id);
		}
	}

	@Override
	public String deletePatient(String id) {
		try {
			Patient patient = patientRepository.findById(id).orElse(null);

			// Delete patient
			patientRepository.deleteById(id);

			return "Patient with ID " + id + " deleted successfully.";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}

	@Override
	public String deleteAllPatient() {
		patientRepository.deleteAll();
		return "All patients deleted successfully.";
	}

}
