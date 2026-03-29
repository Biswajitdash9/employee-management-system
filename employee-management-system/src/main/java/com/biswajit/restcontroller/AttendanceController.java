package com.biswajit.restcontroller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.dto.AttendanceResponseDto;
import com.biswajit.dto.AttendanceStatusRequestDto;
import com.biswajit.entity.base.AttendanceRequestDto;
import com.biswajit.mapper.AttendanceMapper;
import com.biswajit.service.IAttendanceServiceMgmt;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController 
{

	@Autowired private IAttendanceServiceMgmt service;
	
	
	//create checkIn api
	@PostMapping("/checkin")
	public ResponseEntity<String> checkIn(@RequestBody AttendanceRequestDto dto)
	{
		try {
		String msg=service.checkInAttendance(dto);
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	//create Check Out api
    @PostMapping("/checkout")
    public ResponseEntity<String> checkOut(@RequestBody AttendanceRequestDto dto)
    {
    	try {
    	String msg =service.checkOutAttendance(dto);
    	return new ResponseEntity<String>(msg,HttpStatus.CREATED); 
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    //api for manual update by HR
    @PatchMapping("/updatestatus")
    public ResponseEntity<?> updateStatus(@RequestBody AttendanceStatusRequestDto dto )
    {
    	try {
    	AttendanceResponseDto responeDto =service.updateStatus(dto);
    	return new ResponseEntity<AttendanceResponseDto> (responeDto,HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
    	}
    }
    
    //api for retrieval of all attendance for an employee
    @GetMapping("/empallattendance/{Id}")
    public ResponseEntity<?> getEmpAllAttendance (@PathVariable("Id") long empId)
    {
    	
    	try 
    	{
         List<AttendanceResponseDto>	listResponse =service.fetchAllAttendanceByEmpId(empId);
    
          return new ResponseEntity<List<AttendanceResponseDto>>(listResponse,HttpStatus.OK);
    
    	}catch(Error er)
    	{
    		return new ResponseEntity<String>(er.getMessage(),HttpStatus.NOT_FOUND);
    	}
    	catch(Exception e)
    	{
    		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
    	}
 
    }

      //api for retrieval of attendance  of an employee for a particular date
    	@GetMapping("/employee/{empId}/{date}")
    	public ResponseEntity<?> getEmpAttendance(@PathVariable("empId") long empId,
    			                                    @PathVariable("date") LocalDate date)
    	{
    		try {
    		AttendanceResponseDto response=service.fetchAttendanceByEmpId(empId, date);
    		return new ResponseEntity<AttendanceResponseDto>(response,HttpStatus.OK);
    		}
    		catch (Exception e) {
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
    	}
    	         
}
