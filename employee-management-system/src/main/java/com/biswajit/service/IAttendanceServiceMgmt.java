package com.biswajit.service;

import java.time.LocalDate;
import java.util.List;

import com.biswajit.dto.AttendanceResponseDto;
import com.biswajit.dto.AttendanceStatusRequestDto;
import com.biswajit.entity.Attendance;
import com.biswajit.entity.base.AttendanceRequestDto;

public interface IAttendanceServiceMgmt 
{
	//insertion of attendance with checkIn time
	public String checkInAttendance(AttendanceRequestDto dto);
	

	//insertion of attendance with checkOut time
	public String checkOutAttendance(AttendanceRequestDto dto);
	
	//for update status manually
	public AttendanceResponseDto updateStatus(AttendanceStatusRequestDto dto);
	
	//for retrive all attendance of an employee
	public List<AttendanceResponseDto> fetchAllAttendanceByEmpId(Long empId);
	
	//for retrive attendance of an employee for particular day
	public AttendanceResponseDto fetchAttendanceByEmpId(Long empId,LocalDate date);

}
