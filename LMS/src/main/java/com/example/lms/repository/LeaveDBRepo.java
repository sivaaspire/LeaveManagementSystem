package com.example.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.lms.model.LeaveInfo;

public interface LeaveDBRepo extends CrudRepository<LeaveInfo, String> {

}
