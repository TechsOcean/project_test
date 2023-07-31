package com.notification;

import com.item.Item;
import com.user.User;

public class NotificationService {
	public void notifyUser(User user, Item item) {
		System.out.println(item.getHighestBidder().getUserName() + " outbides you. item info : " + item.getName() + ", currentBid: " + item.getCurrentHighestBid());
	}
}
