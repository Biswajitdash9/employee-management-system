package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.User;
import com.biswajit.entity.Employee;


public interface IUserRepository extends JpaRepository<User, Long> 
{
  //check whether the employeeId already registred or not
	public boolean existsByEmployee(Employee employee);
}
