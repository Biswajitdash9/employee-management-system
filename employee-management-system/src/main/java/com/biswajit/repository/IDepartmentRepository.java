package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Department;

public interface IDepartmentRepository  extends JpaRepository<Department, Long>{

}
