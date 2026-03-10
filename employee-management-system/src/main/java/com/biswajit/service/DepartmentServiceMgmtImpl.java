package com.biswajit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswajit.dto.DepartmentRequestDto;
import com.biswajit.dto.DepartmentResponseDto;
import com.biswajit.entity.Department;
import com.biswajit.mapper.DepartmentMapper;
import com.biswajit.repository.IDepartmentRepository;

@Service
public class DepartmentServiceMgmtImpl implements IDepartmentServiceMgmt {
	
	@Autowired private IDepartmentRepository repo;
	
	@Autowired private DepartmentMapper mapper;
	
	@Override
	public DepartmentResponseDto createDepartment(DepartmentRequestDto req) {
		
		Department dept=mapper.toDepartmentEntity(req);
		
		 Department saveddept = repo.save(dept);
		 DepartmentResponseDto resp=mapper.toResponseDto(saveddept);
		 return resp;	 
		 
	}
	
	@Override
	public DepartmentResponseDto getDeptById(Long deptid) {
		
		Department dept = repo.findById(deptid).orElseThrow(()->new IllegalArgumentException("Invalid departmrnt id"));
		
		return mapper.toResponseDto(dept);
		
	}
}
