package com.example.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.lms.model.ProjectInfo;

public interface ProjectDBRepo extends CrudRepository<ProjectInfo, String> {

}
