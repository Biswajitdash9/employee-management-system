package com.biswajit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biswajit.service.IUserServiceMgmt;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired private IUserServiceMgmt service;
}
