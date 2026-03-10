package com.biswajit.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationResponseDto {
	
	private Long designationId;
	private String designationName;
	private List<EmployeeResponseDto> emps;

}
