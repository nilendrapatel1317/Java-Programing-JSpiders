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
	public Optional<Doctor> getDoctorById(String id) {
		
		return doctorRepository.findById(id);
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		doctor.setId(generateID());
		return doctorRepository.save(doctor);
	}
	
	private String generateID() {
		String lastIdStr = doctorRepository.findLastId().orElse("DOC-100");
		int lastNum = Integer.parseInt(lastIdStr.split("-")[1]);
		String newId = "DOC-" + (lastNum + 1);
		return newId;
	}

	@Override
	public Doctor updateDoctor(String id, Doctor updateDoctor) {
		Doctor exitsDoctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
		
		exitsDoctor.setName(updateDoctor.getName());
		
		System.out.println(exitsDoctor.getName());
		System.out.println(updateDoctor.getName());

		return doctorRepository.save(exitsDoctor);
	}

	@Override
	public String deleteDoctor(String id) {
		if(doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);
			return "Doctor Delete SUccessfully !!";
		}
		else {
			return "Doctor Not Found";
		}
	}

	@Override
	public String deleteAllDoctor() {
		doctorRepository.deleteAll();
		return "All Doctors Deleted SUccessfully !!";
	}
	
	
	
	

}
