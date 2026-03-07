package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Salary;

public interface ISalaryRepository extends JpaRepository<Salary, Long>
{
    
}
