package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Leave;

public interface ILeaveRepository extends JpaRepository<Leave,Long> {

}
