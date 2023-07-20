package com.rgt.user.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgt.user.mgmt.payload.UserDto;
import com.rgt.user.mgmt.service.UserServices;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserServices userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getUsers()
	{
		List<UserDto> users = userService.getUsers();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
}
