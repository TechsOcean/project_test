package com.bid;

import com.item.Item;
import com.item.ItemManagementService;
import com.notification.NotificationService;
import com.user.User;
import com.user.UserManagementService;

public class IncrementalBiddingStrategy implements BiddingStrategy{
ItemManagementService itemService = new ItemManagementService();
UserManagementService userService = new UserManagementService();

	@Override
	public void bid(Item item, User user, double amount ) {
        double currentBid = item.getCurrentHighestBid();
        if(amount>currentBid) {
//        	System.out.println("bid amount is greather than previous");
            itemService.updateItem(item, user, amount);
            userService.updateUser(user, amount);
            System.out.println("bid placed successful. your bid amount : Rs "+amount);
            }else {
            	NotificationService notificationService = new NotificationService();
                notificationService.notifyUser(user, item);
            }
    }
}
