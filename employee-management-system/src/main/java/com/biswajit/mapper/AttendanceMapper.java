package com.biswajit.mapper;

import org.springframework.stereotype.Component;

import com.biswajit.dto.AttendanceResponseDto;
import com.biswajit.entity.Attendance;

@Component
public class AttendanceMapper {

	public AttendanceResponseDto toResponse(Attendance attendance)
	{
		//AttendanceResponseDto responseDto=new AttendanceResponseDto();
		return  AttendanceResponseDto.builder()
				.attendanceDate(attendance.getAttendanceDate())
				.checkIn(attendance.getCheckIn())
				.checkOut(attendance.getCheckOut())
				.status(attendance.getStatus())
				.build();
	}
}
