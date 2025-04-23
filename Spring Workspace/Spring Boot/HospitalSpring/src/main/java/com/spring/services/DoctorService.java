package com.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.models.Doctor;

public interface DoctorService {

	public List<Doctor> getAllDoctors();

	public Optional<Doctor> getDoctorById(Long id);

	public Doctor addDoctor(Doctor doctor);

	public Doctor updateDoctor(Long id, Doctor doctor);

	public String deleteDoctor(Long id);
}
