package com.biswajit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biswajit.entity.Attendance;

public interface IAttendanceRepository extends JpaRepository<Attendance, Long> {

}
