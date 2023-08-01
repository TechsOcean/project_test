package com.auction;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import com.item.Item;
import com.user.User;

public class Auction {
	
	private static Auction instance = null;
	private List<Item> items;

	public Auction() {
		super();
		this.items = new ArrayList<>();
	}
	
	public static Auction getInstance() {
		if(instance == null) {
			instance=new Auction();
		}
		return instance;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}

	public void updateItem(Item item, User highestBidder, double highestBid) {
		for(Item it : items) {
			if(it.getName().equals(item.getName()) && it.getDescription().equals(item.getDescription())) {
				it.setCurrentHighestBid(highestBid);
				it.setHighestBidder(highestBidder);
			}
		}
	}
	/*
	 * getters and setters;
	 */
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
