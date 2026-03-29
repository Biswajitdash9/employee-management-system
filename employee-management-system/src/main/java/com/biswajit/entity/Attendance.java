package com.biswajit.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.jar.Attributes.Name;

import com.biswajit.entity.base.BaseAudit;
import com.biswajit.enums.AttendanceStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//Here both the employeeId and attendanceDate work together as constraint value
@Table(name = "Employee_Attendance",
         uniqueConstraints = {
        		 @UniqueConstraint(columnNames = {"employee_id","attendance_date"})
         })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendance extends BaseAudit
{
	@Id
	@SequenceGenerator(sequenceName = "Attendance_seq",name="gen3",initialValue = 100000,allocationSize = 1)
	@GeneratedValue(generator = "gen3",strategy = GenerationType.AUTO)
	private Long attendanceId;
	
	@Column(nullable = false)
	private LocalDate attendanceDate;
	@Column(nullable = false)
	private LocalDateTime checkIn;
	@Column(nullable = true)
	private LocalDateTime checkOut;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AttendanceStatus status;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="employee_id" ,nullable = false)
	private Employee employee;
	

}
