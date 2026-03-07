package com.biswajit.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequestDto 
{
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
    private LocalDate dob;
	
	private String email;
	
	private String phoneNumber;
	
	private String address;
	
	private LocalDate doj;
	

}
