package com.rgt.user.mgmt.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgt.user.mgmt.entity.User;
import com.rgt.user.mgmt.payload.UserDto;
import com.rgt.user.mgmt.service.UserServices;

@RestController
@RequestMapping()
public class PublicController {
	
	@Autowired
	private UserServices userService;
	
	@PostMapping("/signup")
	public ResponseEntity<UserDto> createUser(@RequestBody User user) throws IOException
	{
		UserDto createdUser = userService.createUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
}
