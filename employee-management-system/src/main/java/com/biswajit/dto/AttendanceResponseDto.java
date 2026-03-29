package com.biswajit.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.biswajit.enums.AttendanceStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceResponseDto {
	
	private LocalDate attendanceDate;
	
	private LocalDateTime checkIn;
	
	private LocalDateTime checkOut;
	
	private AttendanceStatus status;
	
	

}
