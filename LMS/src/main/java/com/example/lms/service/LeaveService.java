package com.example.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lms.model.LeaveInfo;
import com.example.lms.repository.LeaveDBRepo;

@Service
public class LeaveService {
	
	@Autowired
	private LeaveDBRepo leaveDBRepository;
	
	public void applyLeave(LeaveInfo leaveDetails) {
		getManagerApproval(leaveDetails);
		leaveDBRepository.save(leaveDetails);
	}
	
	public void updateLeave(LeaveInfo leaveDetails) {
		getManagerApproval(leaveDetails);
		leaveDBRepository.save(leaveDetails);
	}
	
	public void cancelLeave(LeaveInfo leaveDetails) {
		leaveDBRepository.delete(leaveDetails);
	}
	
	public LeaveInfo getLeave(String id) {
		Object leaveDetails =  leaveDBRepository.findById(id);
		return (LeaveInfo)leaveDetails;
	}
	
	private void getManagerApproval(LeaveInfo leaveDetails) {
		leaveDetails.setStatus("APPROVED");
		
	}
	
	

}
