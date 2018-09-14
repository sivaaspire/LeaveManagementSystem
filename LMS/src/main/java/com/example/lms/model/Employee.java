package com.example.lms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empid;
	private String firstName;
	private String lastName;
	private String role;
	private String manager;
	@OneToMany
	private List<LeaveInfo> listOfLeaves;
	@OneToOne
	private ProjectInfo projectInfo;


	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	public int geEmptId() {
		return empid;
	}
	public void setEmpId(int empid) {
		this.empid = empid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<LeaveInfo> getListOfLeaves() {
		return listOfLeaves;
	}

	public void setListOfLeaves(List<LeaveInfo> listOfLeaves) {
		this.listOfLeaves = listOfLeaves;
	}
	
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	
}
