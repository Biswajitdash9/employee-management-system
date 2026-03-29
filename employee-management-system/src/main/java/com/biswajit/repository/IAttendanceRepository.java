package com.biswajit.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biswajit.entity.Attendance;
import com.biswajit.entity.Employee;

public interface IAttendanceRepository extends JpaRepository<Attendance, Long> 
{
	//for finding the attendance record based on employeeid and date
	@Query("From Attendance where attendanceDate=:date and employee=:emp ")
	public Optional<Attendance> findByEmployeeAndDate(Employee emp,LocalDate date);
	
	
	public List<Attendance> findByEmployee(Employee emp);

}
