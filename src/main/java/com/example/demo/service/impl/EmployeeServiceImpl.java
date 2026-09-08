package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepo empRepo;

	@Override
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);

	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
	   //return empRepo.findById(id).orElseThrow();
		
		return empRepo.findById(id).orElseThrow(()-> 
		new EmployeeNotFoundException("Employee not found with Id : "+id)
		);
	}

	@Override
	public void deleteById(Integer id) {
		empRepo.deleteById(id);

	}

	@Override
	public boolean updateEmployee(Employee emp) {
		if( empRepo.existsById(emp.getId())){
			 empRepo.save(emp);
			 return true;
		}else {
		return false;
	}

	}
}
