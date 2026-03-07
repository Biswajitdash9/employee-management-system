package com.biswajit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biswajit.dto.EmployeeRequestDto;
import com.biswajit.dto.EmployeeResponseDto;
import com.biswajit.entity.Employee;
import com.biswajit.mapper.EmployeeMapper;
import com.biswajit.repository.IEmployeeRepository;

import lombok.Builder;

@Service
public class EmployeeServiceMgmtImpl implements IEmployeeServiceMgmt 
{
	@Autowired
	private IEmployeeRepository repo;
	
	@Autowired
	private EmployeeMapper mapper;

//insert employee
	@Override
	public String createEmployee(EmployeeRequestDto request) 
	{
		Employee emp =mapper.toEmployeeEntity(request);
		repo.save(emp);
		return "Employee created";	
		
	}
	
//fetch employee
	@Override
	public EmployeeResponseDto fetchEmpById(Long id) 
	{
		Employee emp=repo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"));
		EmployeeResponseDto response=mapper.toEmpResponseDto(emp);
		return response;
	}
	
//fetch all employess
	@Override
	public List<EmployeeResponseDto> fetchAllEmps() 
	{
		List<EmployeeResponseDto> allempdto=new ArrayList<EmployeeResponseDto>();
		
		List<Employee> allemps =repo.findAll();
		
		for(Employee emp:allemps)
		{
			EmployeeResponseDto response=mapper.toEmpResponseDto(emp);
			allempdto.add(response);
		}
		
		return allempdto;
		
	}
	
//update Contact of phone number
	@Override
	public String updateEmpContactById(Long id, String phno) {
		
		Employee emp =repo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Employee id"));
		emp.setPhoneNumber(phno);
		
		repo.save(emp);
		
		return "Employee Contact number updated";
	}
	
//create multiple employees 
	@Override
	@Transactional
	public List<EmployeeResponseDto> createMultiEmployees(List<EmployeeRequestDto> empDtolist) {
	
		//creating an arraylist of employee entity
		List<Employee> emplist=new ArrayList<Employee>();
		
		//convertion of requestDto object to employee entity object
		for(EmployeeRequestDto Request:empDtolist)
		{
			Employee emp=mapper.toEmployeeEntity(Request);
			//add of employee object to arraylist 
			emplist.add(emp);
			
		}
		
		List<Employee> savedEmps = repo.saveAll(emplist);
		
		List<EmployeeResponseDto> empReslist=new ArrayList<EmployeeResponseDto>();
		
		for(Employee savedemp:savedEmps)
		{
			EmployeeResponseDto response=mapper.toEmpResponseDto(savedemp);
			empReslist.add(response);
		}
		
		return empReslist;
		
		
	}

}
