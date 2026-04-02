package com.biswajit.dto;

import java.util.Set;

import com.biswajit.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto 
{
	private String userName;
	
	private String password;
	
	private long empId;
	
	private String role;

}
