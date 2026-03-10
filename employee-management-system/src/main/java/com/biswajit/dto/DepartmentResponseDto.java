package com.biswajit.dto;

import java.util.List;

import com.biswajit.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDto {

	private Long departmentId;
	
	private String departmentName;
	
	private List<EmployeeResponseDto> empResponseDto;
	
}
