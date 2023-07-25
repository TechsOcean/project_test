package com.messaging.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.messaging.DataStore;
import com.messaging.LoginResponse;
import com.messaging.Tweet;
import com.messaging.User;

public class MessagingHelper {
	
	DataStore dataStore = new DataStore();
	Scanner sc = new Scanner(System.in);
	
	public int mainMenu() {
		System.out.println("1.) Register");
		System.out.println("2.) Login");
		System.out.println("3.) Exit");
		
		System.out.println("Enter choice");
		int choice=sc.nextInt();
		
		return choice;
	}
	
	public User signUpForm() {
		sc.nextLine();
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		
		System.out.print("password: ");
		String password = sc.nextLine();
		
		System.out.print("userName: ");
		String userName=sc.nextLine();
		
		System.out.print("bio: ");
		String bio = sc.nextLine();
		
		User user = new User(name, userName, password, bio);
		return user;
	}
	
	public void signUpMessage(boolean bool) {
		if(bool) {
			System.out.println("user added successfully");
		}
		else {
			System.out.println("there some error while registring");
		}
	}
	
	public String[] loginForm() {
		sc.nextLine();
		System.out.print("Enter userName: ");
		String userName=sc.nextLine();
		
		System.out.print("Enter password:");
		String password=sc.nextLine();
		
		String[] loginDetails = {userName,password};
		return loginDetails;
	}
	
	public void loginMessage(LoginResponse loginResponse)
	{
		if(loginResponse.isLogin()) {
			System.out.println(loginResponse.getUser().getName() + ", login successfully!!");
		}
		else {
			System.out.println("login failed!!");
		}
	}
	
	public int loginedMenu() {
		System.out.println("1.) post a tweet");
		System.out.println("2.) view your timeline");
		System.out.println("3.) search for users");
		System.out.println("4.) search for tweets.");
		System.out.println("5.) view your profile.");
		System.out.println("6.) logout");
		
		int choice = sc.nextInt();
		return choice;
	}
	
	public Tweet createTweet(User user) {
		sc.nextLine();
		System.out.println("what you'd like to tweet!!");
		String content = sc.nextLine();
		
		int tweetId = dataStore.generateTweetId();
		String author = user.getUserName();
		LocalDateTime timeStamp = LocalDateTime.now();
		Tweet tweet = new Tweet(tweetId, content, author, timeStamp);
		System.out.println("!!! successfully tweeted !!!");
		return tweet;
	}

	public void showProfile(User user) {
		System.out.println("hello " + user.getName() + " here is your Twitter profile");
		System.out.println("userName --> "+user.getUserName());
		System.out.println("bio --> "+user.getBio());
		
		List<User> followers = user.getFollowers();
		if(followers == null || followers.size() == 0) {
			System.out.println("followers --> zero");
		}
		else {
			System.out.println("your followers:");
			for(User follower : followers) System.out.println("    "+follower);
		}
		
		List<User> followings = user.getFollowing();
		if(followings == null || followings.size() == 0) {
			System.out.println("you are not following anyone.");
		}
		else {
			System.out.println("your following:");
			for(User following : followings) System.out.println("    "+following);
		}
		
		List<Tweet> tweets = user.getTweets();
		if(tweets == null || tweets.size() == 0) System.out.println("you haven't tweet yet!!");
		else { 
			System.out.println("your Tweets :");
			for(Tweet tweet : tweets) System.out.println("    " + tweet);
		}
	}
	
	public String searchUser() {
		sc.nextLine();
		System.out.println("Enter userName: ");
		String userName = sc.nextLine();
		return userName;
	}
	
	public int userOperation() {
		System.out.println("    1.) follow this user");
		System.out.println("    2.) main menu");
		int loginedUserChoice = sc.nextInt();
		return loginedUserChoice;
	}

	public void showTweets(List<Tweet> tweets) {
		for(Tweet tweet : tweets) System.out.println(tweet);
		
	}

	public Integer inputTweetId() {
		System.out.print("Enter Tweet id to search: ");
		Integer tweetId = sc.nextInt();
		return tweetId;
	}
	
}
