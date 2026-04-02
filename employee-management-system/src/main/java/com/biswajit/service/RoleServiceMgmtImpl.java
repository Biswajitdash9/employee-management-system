package com.biswajit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswajit.dto.RoleRequestDto;
import com.biswajit.dto.RoleResponseDto;
import com.biswajit.entity.Role;
import com.biswajit.mapper.RoleMapper;
import com.biswajit.repository.IRoleRepository;

@Service
public class RoleServiceMgmtImpl implements IRoleServiceMgmt 
{
	@Autowired private IRoleRepository repo;
	@Autowired private RoleMapper mapper;
	
	//for creating Role
	@Override
	public RoleResponseDto createRole(RoleRequestDto dto) {
		
		Role role=new Role();
		role.setRoleName(dto.getRoleName());
		try {
		role=repo.save(role);
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException("Already role exist");
		}
		RoleResponseDto response= mapper.toResponse(role);
		return response;
	
	}
	
	
	//for fetching all Roles available in company
	@Override
	public List<RoleResponseDto> fetchAllRoles() {
		
		List<RoleResponseDto> listResponseRole= new ArrayList<RoleResponseDto>();
		
		List<Role> listRole=repo.findAll();
		if(listRole.isEmpty())
		{
			throw new IllegalArgumentException("Roles are not created yet  . Create one");
		}
		
		//convertion of each role to roleResponseDto
		for(Role role:listRole)
		{
			RoleResponseDto dto=mapper.toResponse(role);
			listResponseRole.add(dto);
				
		}
		
		return listResponseRole;
	}

}


