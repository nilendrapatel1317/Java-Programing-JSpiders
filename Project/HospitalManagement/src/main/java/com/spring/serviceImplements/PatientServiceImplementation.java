package com.spring.serviceImplements;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.models.Bill;
import com.spring.models.Patient;
import com.spring.repositories.AppointmentRepository;
import com.spring.repositories.BillRepository;
import com.spring.repositories.PatientRepository;
import com.spring.services.BillService;
import com.spring.services.PatientService;

@Service
public class PatientServiceImplementation implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private BillService billService;
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
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

	@Override
	public Patient addPatient(Patient patient) {
		patient.setId(generateID());
		return patientRepository.save(patient);  
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
			Patient existingPatient = optionalPatient.get();
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

			List<Bill> bills = patient.getBills();

			// Check if any bill has status == false
			boolean billStatus = bills.stream().anyMatch(bill -> !bill.getStatus());
			if (billStatus) {
				System.out.println("Cannot delete patient. There are unpaid bills");
				return "Cannot delete patient. There are unpaid bills.";
			}


			// Step 2: Delete patient
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
