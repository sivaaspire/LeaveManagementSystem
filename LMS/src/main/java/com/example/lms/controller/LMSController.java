package com.example.lms.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.exceptions.ValidationException;
import com.example.lms.model.Employee;
import com.example.lms.model.LeaveInfo;
import com.example.lms.model.ProjectInfo;
import com.example.lms.service.EmployeeService;
import com.example.lms.service.LeaveService;
import com.example.lms.service.ProjectService;


/**
 * @author siva.lingapandi
 *
 */

@RestController
public class LMSController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LMSController.class);

	@Autowired
	private EmployeeService empService;

	@Autowired
	private LeaveService leaveService;

	@Autowired
	private ProjectService projectService;
	
	
	@RequestMapping("/")
	public String getEmployee() {
		
		return "Welcome to Spring Boot";
	}

	/**
	 * Getting Employee Details based on id
	 * @param id
	 * @return
	 */
	@RequestMapping("/employee/{empid}")
	public Employee getEmployee(@RequestParam String id) {
		LOGGER.info("Requested for Employee Details : {}", id);
		return empService.getEmployee(id);
	}

	/**
	 * Adding new Employee
	 * @param employee
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	public void addToEmployee(@RequestBody Employee employee) {
		LOGGER.info("Adding new Employee Details :" + employee.geEmptId());
		empService.addEmployee(employee);
	}

	/**
	 * Adding new Project
	 * @param projectDetails
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/project")
	public void addToEmployee(@RequestBody ProjectInfo projectDetails) {
		LOGGER.info("Adding new Project Details :" + projectDetails.getProjectid());
		projectService.addProject(projectDetails);
	}

	/**
	 * Applying Leave
	 * @param leaveDetails
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/applyleave")
	public void applyLeave(@RequestBody LeaveInfo leaveDetails) {
		LOGGER.info("Applying leave for the employee Details :" + leaveDetails.getEmployee().geEmptId());
		dataValidation(leaveDetails);
		leaveService.applyLeave(leaveDetails);
	}

	/**
	 * Updating the leave
	 * @param leaveDetails
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/updateleave")
	public void updateLeave(@RequestBody LeaveInfo leaveDetails) {
		LOGGER.info("Updating leave for the employee Details :" + leaveDetails.getEmployee().geEmptId());
		dataValidation(leaveDetails);
		leaveService.updateLeave(leaveDetails);
	}

	/**
	 * Canceling the leave
	 * @param leaveDetails
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/cancelleave")
	public void cancelLeave(@RequestBody LeaveInfo leaveDetails) {
		LOGGER.info("Cancelling leave for the employee Details :" + leaveDetails.getEmployee().geEmptId());
		dataValidation(leaveDetails);
		leaveService.cancelLeave(leaveDetails);
	}

	/**
	 * Getting Leave Details for particular Employee
	 * @param id
	 * @return
	 */
	@RequestMapping("/employee/{empid}/getleave")
	public LeaveInfo getlLeaveDetails(@PathVariable String id) {
		LOGGER.info("Getting leave details for the employee Details {id}:" ,id);
		leaveService.getLeave(id);
		return null;
	}
	
	/**
	 * To Validate input's value
	 * @param leaveDetails
	 */
	public void dataValidation(LeaveInfo leaveDetails) {
		
		LocalDate localDate = LocalDate.now();
		
		int total_no_days  = leaveDetails.getToDate().getDayOfYear() - leaveDetails.getFromDate().getDayOfYear();
		
		
		if(StringUtils.isEmpty(leaveDetails.getFromDate())) {
			throw new ValidationException("From Date should not be empty");
		}
		
		else if(StringUtils.isEmpty(leaveDetails.getToDate())) {
			throw new ValidationException("To Date should not be empty");
		}
		
		else if(StringUtils.isEmpty(leaveDetails.getDescription())) {
			throw new ValidationException("Description should not be empty");
		}
		
		else if(leaveDetails.getFromDate().isBefore(localDate)) {
			throw new ValidationException("From Date should not be less than today's date");
		}
		
		else if(leaveDetails.getToDate().isAfter(leaveDetails.getFromDate())) {
			throw new ValidationException("To Date should not be greater than from date");
		}
		
		else if(leaveDetails.getNoOfDays()!=total_no_days) {
			throw new ValidationException("Please provide correct total no.of days based on from and to date");
		}
		
	}

}
