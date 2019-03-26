package com.ehage.spring.service;

import java.util.List;

import com.ehage.spring.model.Employee;

public interface EmployeeService {
	
	void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();    
    void deleteEmployee(Employee employee); 
    void deleteEmployeeBySsn(String ssn);
    Employee findBySsn(String ssn); 
    void updateEmployee(Employee employee);	

}
