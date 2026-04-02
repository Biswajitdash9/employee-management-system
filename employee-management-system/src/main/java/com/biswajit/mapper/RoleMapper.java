package com.biswajit.mapper;

import org.springframework.stereotype.Component;

import com.biswajit.dto.RoleResponseDto;
import com.biswajit.entity.Role;

@Component
public class RoleMapper 
{
	//convert Role to response
	public RoleResponseDto toResponse(Role role)
	{
		RoleResponseDto dto =new RoleResponseDto();
		dto.setRoleName(role.getRoleName());
		dto.setRoleId(role.getRoleId());
		
		return dto;
	}

}
