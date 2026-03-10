package com.biswajit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biswajit.dto.DesignationRequestDto;
import com.biswajit.dto.DesignationResponseDto;
import com.biswajit.entity.Designation;
import com.biswajit.mapper.DesignationMapper;
import com.biswajit.repository.IDesignationRepository;

@Service
public class DesignationServiceMgmtImpl implements IDesignationServiceMgmt
{

	@Autowired private IDesignationRepository repo;
	
	@Autowired private DesignationMapper mapper;
	
	
	//for creation of designation
	@Override
	public DesignationResponseDto createDesg(DesignationRequestDto req) {
		
	     Designation desg=mapper.toDesignationEntity(req);
	     
	     Designation savedDesg = repo.save(desg);
	     return mapper.toResponseDto(savedDesg);
	}
	
	
	//To get all designation 
	@Override
	public List<DesignationResponseDto> fetchAllDesg() {
		
		//retrieve all designation object
		List<Designation> AllDesg = repo.findAll();
		
		List<DesignationResponseDto> desgResponseDtoList=new ArrayList<DesignationResponseDto>();
		
		//convert designation object to DesignationResponseDto object
		for(Designation desg:AllDesg)
		{
			DesignationResponseDto resp=mapper.toResponseDto(desg);
			desgResponseDtoList.add(resp);
		}
		
		return desgResponseDtoList;
		
	}
	
	//To get designation by id
	@Override
	public DesignationResponseDto fetchDesgById(Long desgId) {
		
		Designation Desg = repo.findById(desgId).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
		return mapper.toResponseDto(Desg);
		
	}
	
}
