package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DBDetails;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Student", description = " Student API Information")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private Environment env;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${student.name}")
	private String name;
	@Value("${student.city}")
	private String city;

	@PostMapping("/saveStudentCourse") // http://localhost:8080/student/saveStudentCourse
	public ResponseEntity<Student> saveStudentCourse(@RequestBody Student student) {

		return ResponseEntity.ok().body(studentService.saveStudent(student));
	}

	@GetMapping("/getData") /// student/getData
	public String getData() {
		return name + " -- " + city;
	}

	@GetMapping("/getDbDeta") /// student/getData
	public DBDetails getDbData() {

		DBDetails dbDetails = new DBDetails();
		dbDetails.setName(env.getProperty("spring.datasource.driver-class-name"));
		dbDetails.setPassword(env.getProperty("spring.datasource.password"));
		dbDetails.setUsername(env.getProperty("spring.datasource.username"));
		dbDetails.setUrl(env.getProperty("spring.datasource.url"));
		dbDetails.setCity(env.getProperty("student.city"));
		;

		return dbDetails;

	}

}
