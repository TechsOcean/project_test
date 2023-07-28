package com.bid;

import com.item.Item;
import com.user.User;

public interface BiddingStrategy {
	void bid(Item item, User user, double amount);
}
