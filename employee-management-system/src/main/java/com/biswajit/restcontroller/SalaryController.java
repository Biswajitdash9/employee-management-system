package com.biswajit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.service.ISalaryServiceMgmt;

@RestController
@RequestMapping("/api/salary")
public class SalaryController 
{

	@Autowired private ISalaryServiceMgmt service;
}
