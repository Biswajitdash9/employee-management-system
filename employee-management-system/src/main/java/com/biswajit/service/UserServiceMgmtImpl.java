package com.biswajit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.biswajit.dto.UserRequestDto;
import com.biswajit.dto.UserResponseDto;
import com.biswajit.entity.User;
import com.biswajit.mapper.UserMapper;
import com.biswajit.repository.IUserRepository;

@Service
public class UserServiceMgmtImpl implements IUserServiceMgmt{

	@Autowired private IUserRepository repo;
	@Autowired private UserMapper mapper;
	
	
	//for create user
	@Override
	public String createUser(UserRequestDto dto) {
	
	User user=mapper.toEntity(dto);
		repo.save(user);
		return "User Created";
	}
	
	//for get all users
	@Override
	public List<UserResponseDto> getAllUser() 
	{
		List<UserResponseDto> listResponse =new ArrayList<UserResponseDto>();
		List<User> listUsers =repo.findAll();
		
		for(User user:listUsers)
		{
			UserResponseDto resp=mapper.toResponse(user);
			listResponse.add(resp);
		}
		
		return  listResponse;
		
		
	}
}
