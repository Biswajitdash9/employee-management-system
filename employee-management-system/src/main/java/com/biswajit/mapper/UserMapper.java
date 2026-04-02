package com.biswajit.mapper;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biswajit.dto.UserRequestDto;
import com.biswajit.dto.UserResponseDto;
import com.biswajit.entity.Employee;
import com.biswajit.entity.Role;
import com.biswajit.entity.User;
import com.biswajit.repository.IEmployeeRepository;
import com.biswajit.repository.IRoleRepository;
import com.biswajit.repository.IUserRepository;

@Component
public class UserMapper {
	@Autowired private IEmployeeRepository empRepo;
	@Autowired private IRoleRepository roleRepo;
	@Autowired private IUserRepository userRepo;
	
	
	//convert  UserRequestDto to User Entity
	public User toEntity(UserRequestDto dto)
	{
		//create an object for User
		User user=new User();
		
		//retrieving Employee entity instance 
		  Employee emp=empRepo.findById(dto.getEmpId())
		    		.orElseThrow(()->new IllegalArgumentException("empid is not present"));
		   
		 //Retrieving Role entity instance 
	  Optional<Role> role=roleRepo.findByIgnoreCaseRoleName(dto.getRole());
	  //create a collection of set to store role object
	    Set<Role> roles= new HashSet<Role>();
	  if(role.isPresent())
	  {
	    roles.add(role.get());
	  }
	  else {
		  throw new IllegalArgumentException("Role is not present ");
	  }
	  
	    //check whether employee already has registred or not	
		if(userRepo.existsByEmployee(emp)) {
			throw new IllegalArgumentException("Already registred");
				
		}
	
	    //set all the input data to user object 
	    user.setUserName(dto.getUserName());
	    user.setPassword(dto.getPassword());
	    user.setEmployee(emp);
	    user.setRoles(roles);
	    
	    return user;

	}
	
	//convert User Entity to UserResponseDto
	public UserResponseDto toResponse(User user)
	{
	     Set<String> onlyRoles=new HashSet<String>();
	     
	     Set<Role> roles=user.getRoles();
	     
	     for(Role role:roles)
	     {
	    	 String singleRole=role.getRoleName();
	    	 onlyRoles.add(singleRole);
	     }
	     
		return UserResponseDto.builder()
				.userName(user.getUserName())
				.password(user.getPassword())
				.roles(onlyRoles)
				.empName(user.getEmployee().getFirstName()+" "+user.getEmployee().getLastName())
				.build();
	}

}
