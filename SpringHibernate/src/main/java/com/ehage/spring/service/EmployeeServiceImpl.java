package com.ehage.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ehage.spring.dao.EmployeeDao;
import com.ehage.spring.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl  implements EmployeeService {

    @Autowired
    private EmployeeDao dao;
     
    public void saveEmployee(Employee employee) {
        dao.save(employee);
    }
 
    public List<Employee> findAllEmployees() {
        return dao.findAll();
    }
 
    public void deleteEmployee(Employee employee) {
        dao.delete(employee);
    }
    
    public void deleteEmployeeBySsn(String ssn) {
    	dao.delete(findBySsn(ssn));
    }
 
    public Employee findBySsn(String ssn) {
        return dao.findBySsn(ssn);
    }
 
    public void updateEmployee(Employee employee){
        dao.save(employee);
    }
	
}
