package com.service;

import java.util.List;
import java.util.Scanner;

import com.bid.AutomaticBiddingStrategy;
import com.bid.BiddingStrategy;
import com.bid.IncrementalBiddingStrategy;
import com.item.Item;
import com.item.ItemFactory;
import com.item.ItemManagementService;
import com.user.User;

public class BiddingService {

	private Scanner sc = new Scanner(System.in);
	private ItemManagementService itemService = new ItemManagementService();
	private ItemFactory itemFactory = new ItemFactory();
	private BiddingStrategy biddingStrategy;

	public int mainMenu() {
		System.out.println("Welcome to Onine Bidding !!!");
		System.out.println("1.) Register User");
		System.out.println("2.) Login User");
		System.out.println("3.) Exit");
		System.out.print("please select an option: ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public User getUserDetail() {
		sc.nextLine();
		System.out.print("Enter UserName: ");
		String userName = sc.nextLine();
		
		System.out.print("Enter password: ");
		String password = sc.nextLine();
		
		User user = new User(userName, password);
		return user;
	}
	
	public int loginedMenu() {
		System.out.print("1. Search Items \r\n"
				+ "2. View Bidding History \r\n"
				+ "3. Add item for auction.\n"
				+ "4. show available items\n"
				+ "5. Logout \r\n"
				+ "Enter choice: ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public Item selectItems(List<Item> items) {
		int i=1;
		
		if(items==null || items.size() == 0) {
			System.out.println("no item exist with this keyword!!");
			return null;
		}
		
		for(Item item : items) {
			System.out.println(i++ + ".) " + item);
		}
		System.out.println("Enter '0' to go back or select an item");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		if(choice == 0) return null;
		if(choice>0 && choice<=items.size()) return items.get(choice-1);
		else {
			System.out.println("please enter appropriate choice.");
			return null;
		}
	}
	
	public Item searchItem() {
		sc.nextLine();
		System.out.print("Enter keyword: ");
		String keyword = sc.nextLine();
		
		List<Item> foundItems = itemService.searchItem(keyword);
		Item selectedItem = selectItems(foundItems);
		return selectedItem;
	}
	
	public void bid(User user) {
		Item item = searchItem();
		if(item != null) {
			System.out.println("Enter a bid amount, greater than ("+item.getCurrentHighestBid()+") : ");
			double newBid = sc.nextDouble();
			
			System.out.println("Select bidding strategy from below list:");
			System.out.println("    1. incremental bidding");
			System.out.println("    2. automatic bidding");
			System.out.println("Enter choice: ");
			int bidStrategy = sc.nextInt();
			
			switch (bidStrategy) {
			case 1:
				biddingStrategy = new IncrementalBiddingStrategy();
				biddingStrategy.bid(item, user, newBid);
				break;
			case 2:
				biddingStrategy = new AutomaticBiddingStrategy();
				biddingStrategy.bid(item, user, newBid);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + bidStrategy);
			}
		}
	}
	
	public Item addItem() {
		System.out.println("Add new Item to auction!");
		sc.nextLine();
		System.out.print("Enter Item name: ");
		String name = sc.nextLine();
		System.out.print("Enter Item Description: ");
		String description = sc.nextLine();
		System.out.print("Enter starting bid: ");
		double startBid = sc.nextDouble();
		
		Item createdItem = ItemFactory.createItem(name, description, startBid);
		return createdItem;
	}
	
	public void printSeprator() {
		System.out.println("");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("");
	}

	public void welcomeUser(User loginedUser) {
		System.out.println("hello, "+loginedUser.getUserName()+", logined successfully!\n");
	}
	
}
