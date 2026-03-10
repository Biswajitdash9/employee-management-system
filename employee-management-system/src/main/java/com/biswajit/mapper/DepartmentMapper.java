package com.biswajit.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biswajit.dto.DepartmentRequestDto;
import com.biswajit.dto.DepartmentResponseDto;
import com.biswajit.dto.EmployeeResponseDto;
import com.biswajit.entity.Department;
import com.biswajit.entity.Employee;

@Component
public class DepartmentMapper {
	
	@Autowired
	private EmployeeMapper mapper;
	
	//convertion.. RequestDto ==>Department Entity
	public   Department toDepartmentEntity(DepartmentRequestDto req)
	{
		Department dept=new Department();
		dept.setDepartmentName(req.getDepartmentName());
		
		return dept;
	}
	
	//Conversion.. Department ==> DepartmentResponseDto
	public DepartmentResponseDto  toResponseDto(Department dept)
	{
		//get all the emps associated with department
		List<Employee> employees = dept.getEmployees();
		
		//create an empty arraylist for EmployeeResponseDto objects
		List<EmployeeResponseDto> dtolist=new ArrayList<EmployeeResponseDto>(); 
		
		//convert the Employee objects to EmployeeResponseDto
		for(Employee emp:employees)
		{
			EmployeeResponseDto dto=mapper.toEmpResponseDto(emp);
			dtolist.add(dto);
		}
		
		DepartmentResponseDto  response= new DepartmentResponseDto();
		response.setDepartmentId(dept.getDepartmentId());
		response.setDepartmentName(dept.getDepartmentName());
		response.setEmpResponseDto(dtolist);
		
		return response;
	}
	
}
