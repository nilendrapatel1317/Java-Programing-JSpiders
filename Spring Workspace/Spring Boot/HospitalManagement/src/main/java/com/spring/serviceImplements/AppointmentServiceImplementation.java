package com.spring.serviceImplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.DTO.AppointmentDTO;
import com.spring.DTO.DoctorDTO;
import com.spring.DTO.PatientDTO;
import com.spring.models.Appointment;
import com.spring.models.Doctor;
import com.spring.models.Patient;
import com.spring.repositories.AppointmentRepository;
import com.spring.repositories.DoctorRepository;
import com.spring.repositories.PatientRepository;
import com.spring.services.AppointmentService;

@Service
public class AppointmentServiceImplementation implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<Appointment> getAllAppointment() {
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment addAppointment(Appointment appointment) {
		Doctor doctor = doctorRepository.findById(appointment.getDoctor().getId())
				.orElseThrow(() -> new RuntimeException("Doctor not found"));

		Patient patient = patientRepository.findById(appointment.getPatient().getId())
				.orElseThrow(() -> new RuntimeException("Patient not found"));

		appointment.setDoctor(doctor);
		appointment.setPatient(patient);

		return appointmentRepository.save(appointment); // ✅ Data will be saved now
	}

	@Override
	public AppointmentDTO addAppointmentDTO(Appointment appointment) {
		// Step 1: Fetch full doctor and patient from DB using ID
		Doctor doctor = doctorRepository.findById(appointment.getDoctor().getId())
				.orElseThrow(() -> new RuntimeException("Doctor not found"));

		Patient patient = patientRepository.findById(appointment.getPatient().getId())
				.orElseThrow(() -> new RuntimeException("Patient not found"));

		// Step 2: Set doctor and patient to appointment object
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);

		// ✅ Step 3: Save appointment to DB
		Appointment savedAppointment = appointmentRepository.save(appointment);

		// Step 4: Prepare DTOs
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setId(doctor.getId());
		doctorDTO.setName(doctor.getName());

		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setId(patient.getId());
		patientDTO.setName(patient.getName());
		patientDTO.setGender(patient.getGender());

		AppointmentDTO appointmentDTO = new AppointmentDTO();
		appointmentDTO.setId(savedAppointment.getId());
		appointmentDTO.setAppointmentDate(savedAppointment.getAppointmentDate());
		appointmentDTO.setDoctor(doctorDTO);
		appointmentDTO.setPatient(patientDTO);

		return appointmentDTO;
	}

	@Override
	public Appointment updateAppointment(Long id, Appointment updateAppointment) {
		Appointment existAppointment = appointmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Appointment Not Found !!"));
		
		existAppointment.setAppointmentDate(updateAppointment.getAppointmentDate());
		return appointmentRepository.save(existAppointment);
	}

	@Override
	public String deleteAppointment(Long id) {
		if (appointmentRepository.existsById(id)) {
			appointmentRepository.deleteById(id);
			return "Appointment Deleted Successfully !!";
		} else
			return "Appointment Not Found !!";
	}

	@Override
	public String deleteAllAppointment() {
		appointmentRepository.deleteAll();
		return "All Appointment Deleted Successfully !!";
	}

	@Override
	public Optional<Appointment> getAppointmentById(Long id) {
		return appointmentRepository.findById(id);
	}

}
