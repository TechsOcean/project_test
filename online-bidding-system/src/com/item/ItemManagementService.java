package com.item;

import java.util.ArrayList;
import java.util.List;

import com.auction.Auction;
import com.user.User;

public class ItemManagementService {

	private Auction auction;
	
	public ItemManagementService() {
		this.auction=auction.getInstance();
	}
	
	public void addItem(Item item) {
		auction.addItem(item);
	}
	
	public void bidAmount(Item item, User user, double bidAmount) {
		List<Item> items = auction.getItems();
		int itemIdx = items.indexOf(item);
		item.setCurrentHighestBid(bidAmount);
		item.setHighestBidder(user);
		items.set(itemIdx, item);
		auction.setItems(items);
		
		
	}
	
	public void getItems(){
		List<Item> items = auction.getItems();
		System.out.println(items);
	}
	
	public List<Item> searchItem(String keyword){
		List<Item> items = auction.getItems();
		List<Item> foundItems = new ArrayList<>();
		for(Item item : items) {
			if(item.getName().contains(keyword) || item.getDescription().contains(keyword)) {
				foundItems.add(item);
			}
		}
		return foundItems;
	}
}
