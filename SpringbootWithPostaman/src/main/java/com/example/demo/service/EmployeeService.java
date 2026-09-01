package com.example.demo.service;

import com.example.demo.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);
	
	public Employee getEmployeeById(Integer id);
	
	public void deleteById(Integer id);
	
	public boolean updateEmployee(Employee emp);
}
