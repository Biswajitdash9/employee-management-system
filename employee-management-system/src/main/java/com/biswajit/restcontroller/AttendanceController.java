package com.biswajit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.service.IAttendanceServiceMgmt;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController 
{

	@Autowired private IAttendanceServiceMgmt service;
}
