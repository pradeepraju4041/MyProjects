package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Employee;
import com.mindtree.exception.DatabaseException;
import com.mindtree.exception.EmployeeNotFoundException;
import com.mindtree.exception.RecordsNotFoundException;
import com.mindtree.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee insertData(@RequestBody Employee employee) {
		return employeeService.insertData(employee);
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllData() throws RecordsNotFoundException {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping("/employee/{empId}")
	public Employee getEmployeeDataById(@PathVariable("id") int empId) {
		return employeeService.getEmployeeData(empId);
	}
	
	@PutMapping("/employee/{id}/{salary}")
	public Employee updateEmployeeSalaryDetails(@PathVariable("id") int empId,@PathVariable("salary") double salary) throws DatabaseException, EmployeeNotFoundException {
		
		
		return employeeService.updateSalary(empId, salary);
	}
	
}
