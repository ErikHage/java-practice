package com.ehage.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehage.spring.model.Employee;

@Repository("employeeDao")
public interface EmployeeDao extends JpaRepository<Employee, Long> {
	
	public Employee findBySsn(String ssn);
	
}
