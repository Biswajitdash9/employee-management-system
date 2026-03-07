package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.User;

public interface IUserRepository extends JpaRepository<User, Long> 
{

}
