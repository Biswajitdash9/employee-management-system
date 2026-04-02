package com.biswajit.service;

import java.util.List;

import com.biswajit.dto.UserRequestDto;
import com.biswajit.dto.UserResponseDto;

public interface IUserServiceMgmt 
{
	//create User
	public String createUser(UserRequestDto dto);
	
	//get all users 
	public List<UserResponseDto> getAllUser();
	

}
