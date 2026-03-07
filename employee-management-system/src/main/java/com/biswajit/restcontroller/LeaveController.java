package com.biswajit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.service.ILeaveServiceMgmt;

@RestController
@RequestMapping("/api/leave")
public class LeaveController 
{
	@Autowired private ILeaveServiceMgmt service;

}
