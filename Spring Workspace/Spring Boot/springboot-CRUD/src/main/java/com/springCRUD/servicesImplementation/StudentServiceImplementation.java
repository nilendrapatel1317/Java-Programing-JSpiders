package com.springCRUD.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springCRUD.models.Student;
import com.springCRUD.repository.StudentRepository;
import com.springCRUD.services.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student addStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public Student editStudentById(int id, Student student) {
		Student oldStudent = studentRepository.findById(id).orElse(null);
		oldStudent.setName(student.getName());
		oldStudent.setAge(student.getAge());
		oldStudent.setGender(student.getGender());
		oldStudent.setPercentage(student.getPercentage());
		
		return studentRepository.save(oldStudent);
	}

	@Override
	public boolean deleteStudentById(int id) {

		studentRepository.deleteById(id);

		return true;
	}

	@Override
	public boolean deleteAllStudents() {
		studentRepository.deleteAll();
		return true;
	}

}
