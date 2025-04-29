package com.springCRUD.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springCRUD.models.Student;
import com.springCRUD.services.StudentService;
import com.springCRUD.structures.ResponseStructure;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET all students
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Student>>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        ResponseStructure<List<Student>> response = new ResponseStructure<>();
        if (students != null && !students.isEmpty()) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMsg("Students fetched successfully");
            response.setData(students);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMsg("No students found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // ADD a new student
    @PostMapping("/add")
    public ResponseEntity<ResponseStructure<Student>> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        ResponseStructure<Student> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMsg("Student added successfully");
        response.setData(savedStudent);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // EDIT (update) student
    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseStructure<Student>> editStudent(@PathVariable int id, @RequestBody Student student) {
        Student updatedStudent = studentService.editStudentById(id, student);
        ResponseStructure<Student> response = new ResponseStructure<>();
        if (updatedStudent != null) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMsg("Student updated successfully");
            response.setData(updatedStudent);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMsg("Student not found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // DELETE student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteStudent(@PathVariable int id) {
        boolean deleted = studentService.deleteStudentById(id);
        ResponseStructure<String> response = new ResponseStructure<>();
        if (deleted) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMsg("Student deleted successfully");
            response.setData("Deleted student with id: " + id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMsg("Student not found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
