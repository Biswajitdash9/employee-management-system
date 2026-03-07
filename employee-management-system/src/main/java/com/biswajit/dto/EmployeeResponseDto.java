package com.biswajit.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseDto
{
	private Long id;
	
    private String firstName;
	
	private String lastName;
	
	private String gender;
	
    private LocalDate dob;
	
	private String email;
	
	private String phoneNumber;
	
	private String address;
	
	private LocalDate doj;
	

}
