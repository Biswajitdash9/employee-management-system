package com.biswajit.dto;

import java.time.LocalDate;

import com.biswajit.enums.AttendanceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceStatusRequestDto {

	private long empId;
	
	private LocalDate date;
	
	private AttendanceStatus status;
}

