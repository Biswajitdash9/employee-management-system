package com.biswajit.service;

import java.util.List;

import com.biswajit.dto.EmployeeRequestDto;
import com.biswajit.dto.EmployeeResponseDto;
import com.biswajit.entity.Employee;

public interface IEmployeeServiceMgmt 
{
	//for creation of an employee
	public String createEmployee(EmployeeRequestDto request);
	
	//for retrieval of employee
	public EmployeeResponseDto fetchEmpById(Long id);
	
	
	//for all employee retrieval
	public List<EmployeeResponseDto> fetchAllEmps();
	
	//for partial updation == Contact no
	public String updateEmpContactById(Long id,String phno);
	
	//for insertion of multiple employees 
	public List<EmployeeResponseDto> createMultiEmployees(List<EmployeeRequestDto> emplist);
	
	
	
}
