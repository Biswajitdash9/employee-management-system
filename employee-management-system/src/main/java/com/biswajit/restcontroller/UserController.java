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

import com.biswajit.dto.UserRequestDto;
import com.biswajit.dto.UserResponseDto;
import com.biswajit.service.IUserServiceMgmt;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired private IUserServiceMgmt service;
	
	//create User 
	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody UserRequestDto dto)
	{
		try {
		String msg= service.createUser(dto);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	//get All user
	@GetMapping("/getAll")
	public ResponseEntity<List<UserResponseDto>> fetchAllUser()
	{
		List<UserResponseDto> allUser = service.getAllUser();
		
		return new ResponseEntity<List<UserResponseDto>>(allUser,HttpStatus.OK);
	}
}
