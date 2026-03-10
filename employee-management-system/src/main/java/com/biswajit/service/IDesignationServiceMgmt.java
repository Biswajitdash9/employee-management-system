package com.biswajit.service;

import java.util.List;

import com.biswajit.dto.DesignationRequestDto;
import com.biswajit.dto.DesignationResponseDto;
import com.biswajit.entity.Designation;


public interface IDesignationServiceMgmt {
	
	//create designation 
	public DesignationResponseDto createDesg(DesignationRequestDto req);
	
	//get designation By id 
	public DesignationResponseDto fetchDesgById(Long desgId);
	
	//get all Designation 
	public List<DesignationResponseDto> fetchAllDesg();
	

}
