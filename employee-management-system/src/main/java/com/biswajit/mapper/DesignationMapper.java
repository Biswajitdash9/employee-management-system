package com.biswajit.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biswajit.dto.DesignationRequestDto;
import com.biswajit.dto.DesignationResponseDto;
import com.biswajit.dto.EmployeeResponseDto;
import com.biswajit.entity.Designation;
import com.biswajit.entity.Employee;

@Component
public class DesignationMapper {

	@Autowired
	private EmployeeMapper mapper;
	
	//convert . DesignationRequestDto ==>Designation
	public Designation  toDesignationEntity(DesignationRequestDto request)
	{
		Designation desg=new Designation();
		desg.setDesignationName(request.getDesignationName());
		
		return desg;
	}
	
	//convert. Designation ==> DesignationResponseDto
	public DesignationResponseDto toResponseDto(Designation desg)
	{
		
		//creation of EmployeeResponseDto arraylist to store object
		List<EmployeeResponseDto> empdtolist=new ArrayList<EmployeeResponseDto>();
		
		//get all emps associated with designation
		List<Employee> listemp=desg.getEmployees();
		
		//convert the employee object to employeeResponseDto object 
		for(Employee emp:listemp)
		{
			EmployeeResponseDto resp=mapper.toEmpResponseDto(emp);
			empdtolist.add(resp);
			
		}
		
		DesignationResponseDto response=new DesignationResponseDto();
		response.setDesignationId(desg.getDesignationId());
		response.setDesignationName(desg.getDesignationName());
		response.setEmps(empdtolist);
		
		return response;
		
	}
}
