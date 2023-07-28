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
            itemService.bidAmount(item, user, amount);
            userService.updateUser(user, amount);
            }else {
            	NotificationService notificationService = new NotificationService();
                notificationService.notifyUser(user, item);
            }
    }
}
