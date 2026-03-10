package com.biswajit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentRequestDto {
	
	private String departmentName;
	
	
	/*
	These are some department names going to include in database
	 
	Software Development
	
	Quality Assurance (QA)
	
	DevOps
	
	IT Support
	
	Human Resources (HR)
	
	Finance
	
	Sales & Marketing
	
	Research and Development (R&D)*/

}
