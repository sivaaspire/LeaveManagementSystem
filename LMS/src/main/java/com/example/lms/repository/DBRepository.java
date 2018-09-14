package com.example.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.lms.model.Employee;

public interface DBRepository extends CrudRepository<Employee, String> {

}
