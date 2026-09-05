package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Student", description=" Student API Information")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/saveStudentCourse")// http://localhost:8080/student/saveStudentCourse
	public ResponseEntity<Student> saveStudentCourse(@RequestBody Student student) {

		return ResponseEntity.ok().body(studentService.saveStudent(student));
	}

}
