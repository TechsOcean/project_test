package com.rgt.user.mgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgt.user.mgmt.entity.User;
import com.rgt.user.mgmt.payload.UserDto;

@Service
public interface UserServices {
	public UserDto createUser(User user);
	
	public UserDto updateUser(Integer id,User user);
	
	public UserDto getUser(Integer id);
	
	public void deleteUser(Integer id);
	
	public List<UserDto> getUsers();
}
