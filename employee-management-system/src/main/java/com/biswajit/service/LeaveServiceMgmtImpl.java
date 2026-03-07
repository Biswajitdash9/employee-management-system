package com.biswajit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswajit.repository.ILeaveRepository;

@Service
public class LeaveServiceMgmtImpl implements ILeaveServiceMgmt {
	
 @Autowired private ILeaveRepository repo;
}
