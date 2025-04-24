package com.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.models.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {}
