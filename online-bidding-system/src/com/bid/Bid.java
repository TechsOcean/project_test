package com.bid;

import com.user.User;

public class Bid {
	private User user;
	
	private double bidAmount;

	
	
	/*
	 * getters and setters;
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	
	
}
