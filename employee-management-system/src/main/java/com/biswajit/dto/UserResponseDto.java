package com.biswajit.dto;

import java.util.Set;

import com.biswajit.entity.Employee;
import com.biswajit.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
	
	private String userName;
	
	private String password;
	
	private String empName;
	
	private Set<String> roles ;

}
