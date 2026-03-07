package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> 
{

}
