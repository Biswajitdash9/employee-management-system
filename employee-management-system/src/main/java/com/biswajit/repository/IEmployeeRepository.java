package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Employee;
import java.util.List;


public interface IEmployeeRepository extends JpaRepository<Employee, Long> 
{
	//for checking employee is present or not by email id
	public boolean findByEmail(String email);

}
