package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/save")// http://localhost:8080/save
	public Employee saveEmployee(@RequestBody Employee emp) {
		Employee emp1=	empService.saveEmployee(emp);
		return emp1;
		
		
	}
	
	@GetMapping("/getEmp/{id}")//http://localhost:8080/getEmp/2
	public Employee getEmployeeById(@PathVariable ("id") Integer id) {
		
		return empService.getEmployeeById(id);
	}
	
	@DeleteMapping("/deleteEmp/{id}")//http://localhost:8080/deleteEmp/3
	public String deleteEmployeeById(@PathVariable ("id") Integer id) {
		
		 empService.deleteById(id);
		 return "Id deleted..";
	}
	
	

}
