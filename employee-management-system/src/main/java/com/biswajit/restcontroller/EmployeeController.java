package com.biswajit.restcontroller;

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

import com.biswajit.dto.EmployeeRequestDto;
import com.biswajit.dto.EmployeeResponseDto;
import com.biswajit.service.IEmployeeServiceMgmt;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController 
{
	@Autowired
	private IEmployeeServiceMgmt service;
	
	
	
	//Insertion of single Employee 
	@PostMapping("/createEmployee")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeRequestDto req)
	{
		String msg=service.createEmployee(req);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	//Insertion of multiple Employees
	@PostMapping("/createMultiEmps")
	public ResponseEntity<List<EmployeeResponseDto>> createMultiEmps(@RequestBody List<EmployeeRequestDto> emplist)
	{
	  List<EmployeeResponseDto> respEmpDto=	service.createMultiEmployees(emplist);
	  
	  return new ResponseEntity<List<EmployeeResponseDto>>(respEmpDto,HttpStatus.CREATED);
		
	}
	
	
	//find employee by id
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable("id") Long empid)
	{
		EmployeeResponseDto response= service.fetchEmpById(empid);
		
		return new ResponseEntity<EmployeeResponseDto>(response,HttpStatus.OK);
	}
	
	
	//find all employee
	@GetMapping("/getAllEmps")
	public ResponseEntity<List<EmployeeResponseDto>> getAllEmployee()
	{
		List<EmployeeResponseDto> allemps=service.fetchAllEmps();
		
		return new ResponseEntity<List<EmployeeResponseDto>>(allemps,HttpStatus.OK);
	}
	
	//update employee
	@PatchMapping("/updatecont/{id}/{phno}")
	public ResponseEntity<String> updateContact(@PathVariable("id") Long empid,
			                                        @PathVariable("phno") String phn)
	{
		String msg=service.updateEmpContactById(empid, phn);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
				
	}
}
