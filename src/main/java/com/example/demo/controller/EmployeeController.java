package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Employee", description = " Employee API Information")
@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/save") // http://localhost:8080/emp/save
	@Operation(description = " Rest Api is used to save Employee Information")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Employee Information Saved Successfully") })
	public Employee saveEmployee(@Valid @RequestBody Employee emp) {
		Employee emp1 = empService.saveEmployee(emp);
		return emp1;

	}

	@GetMapping("/getEmp/{id}") // http://localhost:8080/emp/getEmp/2
	@Operation(description = " Rest Api is used to Get Employee Information")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Employee Information get Successfully") })
	public Employee getEmployeeById(@PathVariable("id") Integer id) {

		return empService.getEmployeeById(id);
	}

	@DeleteMapping("/deleteEmp/{id}") // http://localhost:8080/emp/deleteEmp/3
	@Operation(description = " Rest Api is used to Delete Employee Information")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Employee Information Deleted Successfully") })
	public String deleteEmployeeById(@PathVariable("id") Integer id) {

		empService.deleteById(id);
		return "Id deleted..";
	}


}
