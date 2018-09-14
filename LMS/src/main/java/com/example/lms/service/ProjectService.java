package com.example.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.model.ProjectInfo;
import com.example.lms.repository.ProjectDBRepo;

@Service
public class ProjectService {
	@Autowired
	private ProjectDBRepo projectDBRepository;
	
	public void addProject(ProjectInfo project) {
		projectDBRepository.save(project);
	}

}
