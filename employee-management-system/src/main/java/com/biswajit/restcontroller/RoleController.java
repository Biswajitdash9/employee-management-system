package com.biswajit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.dto.RoleRequestDto;
import com.biswajit.dto.RoleResponseDto;
import com.biswajit.service.IRoleServiceMgmt;

@RestController
@RequestMapping("/api/role")
public class RoleController
{

	@Autowired private IRoleServiceMgmt service;
	
	//api for creation of Role
	@PostMapping("/create")
	public ResponseEntity<?> createRole(@RequestBody RoleRequestDto dto)
	{
		try {
	  RoleResponseDto response	=service.createRole(dto); 
	  return new ResponseEntity<RoleResponseDto>(response,HttpStatus.CREATED);
		}
	catch(Exception e)
	
	{
		return new  ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
   }
	
	//api for retrieving all roles available in company
	@GetMapping("/all")
	public ResponseEntity<?> fetchAllRoles()
	{
		try {
	List<RoleResponseDto> listResponse= service.fetchAllRoles();
	return new ResponseEntity<List<RoleResponseDto>>(listResponse,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
	
		
	}
	
}