package com.spring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	// Custom Query
	List<Patient> findByAge(int age);

	List<Patient> findByAgeAndName(int age, String name);

}
