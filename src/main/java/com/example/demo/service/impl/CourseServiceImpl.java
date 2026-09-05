package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepo;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepo courseRepo;

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepo.save(course);
	}
	

}
