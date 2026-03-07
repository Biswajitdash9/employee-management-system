package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Designation;

public interface IDesignationRepository extends JpaRepository<Designation, Long> 
{

}
