package com.item;

import com.user.User;

public class Item {
	private String name; 
    private String description; 
    private double currentHighestBid; 
    private User highestBidder;
	public Item(String name, String description, double startingBid) {
		super();
		this.name = name;
		this.description = description;
		this.currentHighestBid = startingBid;
		this.highestBidder=null;
	}
	
	public void placeBid(User user, double biddingAmount) {
		if(biddingAmount>currentHighestBid) {
			this.currentHighestBid=biddingAmount;
			highestBidder=user;
		}
	}

	
	/*
	 * getters and setters;
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCurrentHighestBid() {
		return currentHighestBid;
	}

	public void setCurrentHighestBid(double currentHighestBid) {
		this.currentHighestBid = currentHighestBid;
	}

	public User getHighestBidder() {
		return highestBidder;
	}

	public void setHighestBidder(User highestBidder) {
		this.highestBidder = highestBidder;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", description=" + description + ", currentHighestBid=" + currentHighestBid
				+ ", highestBidder=" + highestBidder + "]";
	}
    
    
}
