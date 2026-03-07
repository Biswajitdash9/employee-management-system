package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> 
{
	

}
