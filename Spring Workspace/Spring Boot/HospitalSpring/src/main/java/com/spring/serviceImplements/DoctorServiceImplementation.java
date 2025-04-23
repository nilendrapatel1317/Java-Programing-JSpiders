package com.spring.serviceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.models.Doctor;
import com.spring.repositories.DoctorRepository;
import com.spring.services.DoctorService;

@Service
public class DoctorServiceImplementation implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Optional<Doctor> getDoctorById(Long id) {
		
		return doctorRepository.findById(id);
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Long id, Doctor updateDoctor) {
		Doctor exitsDoctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
		
		exitsDoctor.setName(updateDoctor.getName());
		
		System.out.println(exitsDoctor.getName());
		System.out.println(updateDoctor.getName());

		return doctorRepository.save(exitsDoctor);
	}

	@Override
	public String deleteDoctor(Long id) {
		if(doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);
			return "Doctor Delete SUccessfully !!";
		}
		else {
			return "Doctor Not Found";
		}
	}
	
	
	
	

}
