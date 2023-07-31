package com.bid;

import com.item.Item;
import com.item.ItemManagementService;
import com.notification.NotificationService;
import com.user.User;
import com.user.UserManagementService;

public class AutomaticBiddingStrategy implements BiddingStrategy {
	private ItemManagementService itemService = new ItemManagementService();
	private UserManagementService userService = new UserManagementService();
	
	@Override
	public void bid(Item item, User user, double maxAmount) {
		double currentHighestBid = item.getCurrentHighestBid();
		currentHighestBid++;
		if(currentHighestBid<=maxAmount) {
			itemService.updateItem(item, user, maxAmount);
			userService.updateUser(user, currentHighestBid);
			System.out.println("bid placed successful. your bid amount : Rs "+currentHighestBid);
		}
		else {
			NotificationService notificationService = new NotificationService();
			notificationService.notifyUser(item.getHighestBidder(), item);
		}
	}
}
