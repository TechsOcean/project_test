package com.user;

import java.util.ArrayList;
import java.util.List;

import com.item.Item;

public class UserManagementService {
	private static List<User> users=new ArrayList<>();
	
//	public UserManagementService() {
//		this.users = new ArrayList<>();
//	}
	
	public void createUser(User user) {
		users.add(user);
	}
	
	public void updateUser(User user, double bidAmount)
	{
		for(User u : users) {
			if(u.getUserName().equals(user.getUserName())) {
				u.getBiddingHistory().add(bidAmount);
			}
		}
	}
	
	public User authenticateUser(User user) {
		for(User u : users) {
			if(u.getUserName().equals(user.getUserName()) && u.getPassword().equals(user.getPassword())) return u;
		}
		System.out.println("authentication failed, please try again!!");
		return null;
	}
}
