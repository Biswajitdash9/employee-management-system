package com.biswajit.service;

import java.util.ArrayList;
import java.util.List;

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
	
	// create department
	@Override
	public DepartmentResponseDto createDepartment(DepartmentRequestDto req) {
		
		Department dept=mapper.toDepartmentEntity(req);
		
		 Department saveddept = repo.save(dept);
		 DepartmentResponseDto resp=mapper.toResponseDto(saveddept);
		 return resp;	 
		 
	}
	//  get department by id
	@Override
	public DepartmentResponseDto getDeptById(Long deptid) {
		
		Department dept = repo.findById(deptid).orElseThrow(()->new IllegalArgumentException("Invalid departmrnt id"));
		
		return mapper.toResponseDto(dept);
		
	}
	
	//Get all department 
	@Override
	public List<DepartmentResponseDto> getAllDept() {
		
		List<Department> allDept = repo.findAll();
		
		//create DepartmentResponseDto arraylist for store object
		List<DepartmentResponseDto>  listDeptResponse=new ArrayList<DepartmentResponseDto>();
		
		for(Department dept:allDept)
		{
			DepartmentResponseDto deptDto=mapper.toResponseDto(dept);
			listDeptResponse.add(deptDto);
		}
		
		
		return listDeptResponse;
	}
}
