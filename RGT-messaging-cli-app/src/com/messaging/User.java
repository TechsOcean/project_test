package com.messaging;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	private String userName;
	private String password;
	private String bio;
	private List<User> following;
	private List<User> followers;
	private List<Tweet> tweets;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", userName=" + userName + "]";
	}

	public User() {
		super();
		this.followers = new ArrayList<>();
		this.following = new ArrayList<>();
		this.tweets = new ArrayList<>();
	}

	public User(String name, String userName, String password, String bio) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.bio = bio;
		this.followers = new ArrayList<>();
		this.following = new ArrayList<>();
		this.tweets = new ArrayList<>();
	}
	
	public void postTweet(Tweet tweet) {
		if(tweets == null) tweets = new ArrayList<>();
		tweets.add(tweet);
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<User> getFollowing() {
		return following;
	}

	public void setFollowing(List<User> following) {
		this.following = following;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	
}
