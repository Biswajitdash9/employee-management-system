package com.biswajit.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.biswajit.dto.EmployeeRequestDto;
import com.biswajit.dto.EmployeeResponseDto;
import com.biswajit.entity.Employee;

@Component
public class EmployeeMapper {
	
	
	//conversion - EmployeeRequestDto ===>Employee
	public Employee toEmployeeEntity(EmployeeRequestDto req)
	{
		Employee emp=new Employee();
		BeanUtils.copyProperties(req, emp);
		return emp;
		
	}
	
	//conversion - Employee ===>EmployeeResponseDto
	public EmployeeResponseDto toEmpResponseDto(Employee emp)
	{
		
		
	return EmployeeResponseDto.builder()
			.id(emp.getEmployeeId())
			.firstName(emp.getFirstName())
			.lastName(emp.getLastName())
			.gender(emp.getGender())
			.dob(emp.getDob())
			.email(emp.getEmail())
			.phoneNumber(emp.getPhoneNumber())
			.address(emp.getAddress())
			.doj(emp.getDoj())
			.build();
			
			
		
		//BeanUtils.copyProperties(emp, response);
		
	}

}
