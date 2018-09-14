package com.example.lms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lms.model.Employee;
import com.example.lms.repository.DBRepository;


@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private DBRepository employeeDBRepository;

	public void addEmployee(Employee emp) {
		LOGGER.info("Adding new Employee Details to the database :"+emp.geEmptId() );
		employeeDBRepository.save(emp);
	}
	
	public Employee getEmployee(String id) {
		LOGGER.info("Getting Employee Details from the database :"+id );
		Object employee = employeeDBRepository.findById(id);
		return (Employee) employee;
	}
	
}
