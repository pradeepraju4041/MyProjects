package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	

}
