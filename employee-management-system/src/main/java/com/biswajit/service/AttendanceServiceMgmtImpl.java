package com.biswajit.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswajit.dto.AttendanceResponseDto;
import com.biswajit.dto.AttendanceStatusRequestDto;
import com.biswajit.entity.Attendance;
import com.biswajit.entity.Employee;
import com.biswajit.entity.base.AttendanceRequestDto;
import com.biswajit.enums.AttendanceStatus;
import com.biswajit.mapper.AttendanceMapper;
import com.biswajit.repository.IAttendanceRepository;
import com.biswajit.repository.IEmployeeRepository;

@Service
public class AttendanceServiceMgmtImpl implements IAttendanceServiceMgmt 
{
	@Autowired private IAttendanceRepository repo;
	@Autowired private IEmployeeRepository empRepo;
	@Autowired private AttendanceMapper mapper;
	
	//for check in 
	@Override
	public String checkInAttendance(AttendanceRequestDto dto) 
	{
		LocalDateTime now=LocalDateTime.now();
		Employee  emp=empRepo.findById(dto.getEmpId())
				.orElseThrow(()->new IllegalArgumentException("Employee id does not exist"));
		
	
		Attendance attendance=new Attendance();
		attendance.setEmployee(emp);
		attendance.setAttendanceDate(LocalDate.now());
		attendance.setCheckIn(now);
		
		LocalTime time=now.toLocalTime();
		
		if(time.isBefore(LocalTime.of(9, 00, 00)) || time.equals(LocalTime.of(9,0,0)))
		{
			attendance.setStatus(AttendanceStatus.PRESENT);
		}
		else if(time.isAfter(LocalTime.of(9, 0)) && time.isBefore(LocalTime.of(10, 0)))
		{
			attendance.setStatus(AttendanceStatus.LATE);
		}
		else {
			attendance.setStatus(AttendanceStatus.HALF_DAY);
		}
		
		repo.save(attendance);
		return "Checked in successfully";
		
		
	}
	
	//for check out
	@Override
	public String checkOutAttendance(AttendanceRequestDto dto) 
	{
		LocalDateTime time=LocalDateTime.now();
		Employee emp=empRepo.findById(dto.getEmpId())
				.orElseThrow(()->new IllegalArgumentException("Employee id does not exist"));
		
	Optional<Attendance> attendanceOpt=repo.findByEmployeeAndDate(emp, LocalDate.now());
	
	if(attendanceOpt.isPresent())
	{
		Attendance attendance=attendanceOpt.get();
		if(attendance.getCheckOut()==null) {
		attendance.setCheckOut(time);
		repo.save(attendance);
		return "checked out successfully";
		}
		else throw new IllegalArgumentException("Already checked out");
	}
	else
		 throw new IllegalArgumentException("Check in not found for the day");
		
		
	}

	//for fetch all attendance of an Employee
	@Override
	public List<AttendanceResponseDto> fetchAllAttendanceByEmpId(Long empId) {
		
		Employee emp=empRepo.findById(empId).orElseThrow(()->new IllegalArgumentException("Invalid id"));
		
	List<AttendanceResponseDto> responseList=new ArrayList<AttendanceResponseDto>();
	
	List<Attendance> attendances=repo.findByEmployee(emp);
	
	if(attendances.isEmpty())
	{
		throw new Error("for this employee attendances does not exist");
	}
	
	for(Attendance attendance:attendances)
	{
		AttendanceResponseDto reponse=mapper.toResponse(attendance);
		responseList.add(reponse);
	}
	
	return responseList;
		
	}
	
	
	//for fetch attendance of an employee for a particular day
	@Override
	public AttendanceResponseDto fetchAttendanceByEmpId(Long empId, LocalDate date) {
		
		Employee emp=empRepo.findById(empId).orElseThrow(()->new IllegalArgumentException("Invalid id"));
	
		Optional<Attendance> attendanceOpt=repo.findByEmployeeAndDate(emp, date);
		
		if(attendanceOpt.isPresent())
		{
			Attendance attendance=attendanceOpt.get();
			AttendanceResponseDto response=mapper.toResponse(attendance);
			return response;
		}
		throw new IllegalArgumentException("for this date attendance does not exist");
		


	}
	
	//for updation of  status manually By HR and Admin
	@Override
	public AttendanceResponseDto updateStatus(AttendanceStatusRequestDto dto) {
	
		Employee emp=empRepo.findById(dto.getEmpId())
				.orElseThrow(()->new IllegalArgumentException("Employee does not exist"));
		Optional<Attendance> opt=repo.findByEmployeeAndDate(emp, dto.getDate());
		if(opt.isPresent())
		{
			Attendance attendance=opt.get();
			attendance.setStatus(dto.getStatus());
			return  mapper.toResponse(repo.save(attendance));
			
		}
		throw new IllegalArgumentException("No Check In found for the day");
	}
	
	
}
