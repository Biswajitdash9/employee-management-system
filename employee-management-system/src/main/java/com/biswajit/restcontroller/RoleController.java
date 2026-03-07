package com.biswajit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.repository.IRoleRepository;
import com.biswajit.service.IRoleServiceMgmt;

@RestController
@RequestMapping("/api/role")
public class RoleController
{

	@Autowired private IRoleServiceMgmt service;
}
