package com.biswajit.service;

import java.util.List;

import com.biswajit.dto.RoleRequestDto;
import com.biswajit.dto.RoleResponseDto;
import com.biswajit.entity.Role;

public interface IRoleServiceMgmt 
{
	//for creation of role
	public RoleResponseDto createRole(RoleRequestDto dto);
	
	
	//to retrieve all roles from table
	public List<RoleResponseDto> fetchAllRoles();

}
