package com.springCRUD.services;

import java.util.List;

import com.springCRUD.models.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student getStudentById(int id);
	
	Student addStudent(Student student);
	
	Student editStudentById(int id,Student student);
	
	boolean deleteStudentById(int id);
	
	boolean deleteAllStudents();
}
