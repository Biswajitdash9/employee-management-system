package com.biswajit.service;

import java.util.List;

import com.biswajit.dto.DepartmentRequestDto;
import com.biswajit.dto.DepartmentResponseDto;
import com.biswajit.entity.Department;

public interface IDepartmentServiceMgmt {
	
	//for creation of department
	public DepartmentResponseDto createDepartment(DepartmentRequestDto req);
	
	//To get the department data
	public DepartmentResponseDto getDeptById(Long deptid);
	
	//To get all department details
	public List<DepartmentResponseDto> getAllDept();
	

}
