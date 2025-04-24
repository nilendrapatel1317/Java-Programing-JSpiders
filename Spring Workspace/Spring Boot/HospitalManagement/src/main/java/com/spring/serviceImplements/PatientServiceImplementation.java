package com.spring.serviceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Patient> getPatientById(Long id) {
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
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient updatedPatient) {
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
    public String deletePatient(Long id) {
        patientRepository.deleteById(id);
        return "Patient with ID " + id + " deleted successfully.";
    }

    @Override
    public String deleteAllPatient() {
        patientRepository.deleteAll();
        return "All patients deleted successfully.";
    }
}
