package com.main;

import java.util.List;

import com.item.Item;
import com.item.ItemManagementService;
import com.service.BiddingService;
import com.user.User;

/**
 * contains bidding services;
 * 	
 * @author Bharat
 */

public class LoginedUser {
	private BiddingService biddingService = new BiddingService();
	private ItemManagementService itemService = new ItemManagementService();
	private User loginedUser;
	
	public LoginedUser(User loginedUser) {
		super();
		this.loginedUser=loginedUser;
	}
	
	//handle all the operations a login user can do.
	public void loginService() {
		
		int loginedUserChoice;
		
		do {
			loginedUserChoice = biddingService.loginedMenu(); // loginMenu-> show available options a login user can do
															  //and return the selected option.
			switch (loginedUserChoice){
			
			//search items;
			case 1:
				biddingService.bid(loginedUser);
				break;
				
				
			//view bidding history;
			case 2:
				List<Double> biddingHistory = loginedUser.getBiddingHistory();
				if(biddingHistory.size() == 0) System.out.println("no bidding done yet.");
				else System.out.println(biddingHistory);
				break;
			
				
			//add item for auction;
			case 3:
				Item item = biddingService.addItem();
				loginedUser.addBid(item.getCurrentHighestBid());
				item.setHighestBidder(loginedUser);
				itemService.addItem(item);
				System.out.println(item + "added successfully!");
				break;
							
			//logout;
			case 5:
				System.out.println("\nlogout successfully!!\n");
				break;
			
			//print items;
			case 4:
				itemService.getItems();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + loginedUserChoice);
			}
			
			biddingService.printSeprator();
		}
		while(loginedUserChoice != 5);
	}
}
