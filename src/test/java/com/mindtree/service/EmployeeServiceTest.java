package com.mindtree.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.mindtree.entity.Employee;
import com.mindtree.repository.EmployeeRepository;


@SpringBootTest
class EmployeeServiceTest {

	@MockBean
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeService employeeService;

	@Test
	void testInsertData() {
		Employee employee = new Employee(103, "sunil", 6000, "developer");
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeService.insertData(employee));

	}

	@Test
	void testGetEmployeeData() {

		Optional<Employee> employee = Optional.of(new Employee(101, "pradeep", 5000, "Engineer"));
		int empId = 101;
		when(employeeRepository.findById(empId)).thenReturn(employee);
		assertEquals("pradeep", employeeService.getEmployeeData(empId).getName());

	}

	@Test
	void testGetAllEmployees() {

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(101, "pradeep", 5000, "Engineer"));
		employees.add(new Employee(102, "kumar", 6000, "Engineer"));

		when(employeeRepository.findAll()).thenReturn(employees);
		assertEquals(2, employeeService.getAllEmployees().size());

	}

	@Test
	void testUpdateSalary() {
		Employee employee = new Employee(102, "kumar", 6000, "Engineer");

		when(employeeRepository.getById(102)).thenReturn(employee);
		employee.setSalary(10000);
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeService.updateSalary(102, 10000));

	}

}
