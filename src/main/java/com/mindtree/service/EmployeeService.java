package com.mindtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.entity.Employee;
import com.mindtree.exception.DatabaseException;
import com.mindtree.exception.EmployeeNotFoundException;
import com.mindtree.exception.RecordsNotFoundException;
import com.mindtree.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Transactional
	public Employee insertData(Employee employee) {
		return employeeRepository.save(employee);

	}

	@Transactional
	public Employee getEmployeeData(int empId) {

		return employeeRepository.findById(empId).get();

	}

	@Transactional
	public List<Employee> getAllEmployees() throws RecordsNotFoundException {
		List<Employee> employees = employeeRepository.findAll();
		System.out.println(employees);
		if (employees.size() == 0) {
			throw new RecordsNotFoundException("there is no Person present");
		}

		return employeeRepository.findAll();

	}

	@Transactional
	public Employee updateSalary(int empId, double salary) throws DatabaseException, EmployeeNotFoundException {
		Employee employee = employeeRepository.getById(empId);
		employee.setSalary(salary);
		try {
			if (!employeeRepository.existsById(empId)) {

				throw new EmployeeNotFoundException("No Employee found with that Id");
			}

			Employee updateEmployee = employeeRepository.save(employee);
			return updateEmployee;
		} catch (DataAccessException e) {
			throw new DatabaseException(e);

		}
	}
}
