package com.biswajit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.dto.DepartmentRequestDto;
import com.biswajit.dto.DepartmentResponseDto;
import com.biswajit.service.IDepartmentServiceMgmt;

@RestController
@RequestMapping("/api/department")
public class DepartmentController 
{

	@Autowired
	private IDepartmentServiceMgmt service;
	
	
	//create department 
	@PostMapping("/create")
	public ResponseEntity<DepartmentResponseDto> createDepartment(@RequestBody DepartmentRequestDto req )
	{
	       DepartmentResponseDto responseDto = service.createDepartment(req);
	       
	       return new ResponseEntity<DepartmentResponseDto>(responseDto,HttpStatus.CREATED);
	}
	
	//to get Department details by id
	@GetMapping("/get/{id}")
	public ResponseEntity<DepartmentResponseDto> fetchDepartment(@PathVariable("id") Long deptid)
	{
		 DepartmentResponseDto resp = service.getDeptById(deptid);
		 return new ResponseEntity<DepartmentResponseDto>(resp,HttpStatus.OK);
		 
	}
	
	//to get all department details
	@GetMapping("/getall")
	public ResponseEntity<List<DepartmentResponseDto>> fetchAllDept()
	{
		List<DepartmentResponseDto> listDept=service.getAllDept();
		return new ResponseEntity<List<DepartmentResponseDto>>(listDept,HttpStatus.OK);
	}
	
}
