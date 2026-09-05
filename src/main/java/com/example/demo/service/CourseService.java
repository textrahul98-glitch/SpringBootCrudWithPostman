package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Course;

@Service
public interface CourseService {
	
	public Course saveCourse(Course course);

}
