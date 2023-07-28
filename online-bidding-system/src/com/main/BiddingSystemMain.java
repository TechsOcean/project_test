package com.main;

import com.service.BiddingService;
import com.user.User;
import com.user.UserManagementService;

public class BiddingSystemMain {
	private static BiddingService biddingService = new BiddingService();
	private static UserManagementService userService = new UserManagementService();
	
	
	public static void main(String[] args) {
		int mainMenuChoice;
		int loginUserChoice;
		User registeredUser;
		User loginedUser;
		
		do {
			mainMenuChoice = biddingService.mainMenu();
			
			switch (mainMenuChoice) {
			case 1:
				System.out.println("\nRegistration form!!");
				registeredUser = biddingService.getUserDetail();
				userService.createUser(registeredUser);
				System.out.println("registration successful!");
				break;
				
			case 2:
				System.out.println("\nlogin form!!");
				loginedUser = biddingService.getUserDetail();
				loginedUser = userService.authenticateUser(loginedUser);
				if(loginedUser != null) {
					biddingService.welcomeUser(loginedUser);
					LoginedUser loginedUserService = new LoginedUser(loginedUser);
					loginedUserService.loginService();
				}
				break;
				
			case 3:
				System.out.println("\nvisit again!!");
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + mainMenuChoice);
			}
			biddingService.printSeprator();
		}
		while(mainMenuChoice != 3);
	}
}
