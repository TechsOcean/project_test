package com.rgt.user.mgmt.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgt.user.mgmt.entity.User;
import com.rgt.user.mgmt.payload.UserDto;
import com.rgt.user.mgmt.repository.UserRepository;
import com.rgt.user.mgmt.service.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDto createUser(User user) {
		User savedUser = userRepo.save(user);
		UserDto userDto = userToDto(savedUser);
		return userDto;
	}

	@Override
	public UserDto updateUser(Integer id, User user) {
		User updatedUser = userRepo.updateUser(id,user);
		UserDto userDto = userToDto(updatedUser);
		return userDto;
	}

	@Override
	public UserDto getUser(Integer id) {
		User userById = userRepo.getUserById(id);
		UserDto userDto = null;
		if(userById != null)
		{
			userDto = userToDto(userById);
			return userDto;
		}
		else {
			System.out.println("user is null..");
			return userDto;
		}
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.DeleteUser(id);
		return;
	}

	@Override
	public List<UserDto> getUsers() {
		List<User> listOfUsers = new ArrayList<>();
		listOfUsers = userRepo.getUsers();
		List<UserDto> collect = listOfUsers.stream().map(user -> userToDto(user)).collect(Collectors.toList()); 
		Collections.sort(collect, new Comparator<UserDto>() {

			@Override
			public int compare(UserDto o1, UserDto o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});;
		return collect;
	}
	
	//maps the user object to userDto object.
	public UserDto userToDto(User user) {
		UserDto userDto= new UserDto();
		userDto.setId(user.getId());
		userDto.setUserName(user.getUserName());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}
}
