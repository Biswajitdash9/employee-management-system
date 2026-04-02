package com.biswajit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> 
{
	public Optional<Role> findByIgnoreCaseRoleName(String roleName);

}
