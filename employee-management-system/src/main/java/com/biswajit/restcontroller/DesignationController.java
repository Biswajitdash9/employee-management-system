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

import com.biswajit.dto.DesignationRequestDto;
import com.biswajit.dto.DesignationResponseDto;
import com.biswajit.service.IDesignationServiceMgmt;

@RestController
@RequestMapping("/api/designation")
public class DesignationController 
{
	@Autowired
	private IDesignationServiceMgmt service;
	
	//create Designation
	@PostMapping("/create")
	public ResponseEntity<DesignationResponseDto> createDesg(@RequestBody DesignationRequestDto req)
	{
		DesignationResponseDto desg = service.createDesg(req);
		return new ResponseEntity<DesignationResponseDto>(desg,HttpStatus.CREATED);
	}
	
	//Get designation By id 
	@GetMapping("/get/{id}")
	public ResponseEntity<DesignationResponseDto> fetchDesgById(@PathVariable("id") Long desgId)
	{
		return new ResponseEntity<DesignationResponseDto>(service.fetchDesgById(desgId),HttpStatus.OK);
	}
	
	//Get all Designations
	@GetMapping("/getall")
	public ResponseEntity<List<DesignationResponseDto>> fetchAllDesg()
	{
		List<DesignationResponseDto> desgList=service.fetchAllDesg();
		return new ResponseEntity<List<DesignationResponseDto>>(desgList,HttpStatus.OK);
	}

}
