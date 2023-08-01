package com.user;

import java.util.ArrayList;
import java.util.List;

import com.bid.Bid;

public class User {
	private String userName;
	private String password;
	private List<Double> biddingHistory;
	
	public User(String userName, String password) {
		this.userName=userName;
		this.password=password;
		this.biddingHistory = new ArrayList<>();
	}
	
	public void addBid(double bidAmount) {
		this.biddingHistory.add(bidAmount);
	}

	
	/*
	 * getters and setters;
	 */
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

	public List<Double> getBiddingHistory() {
		return biddingHistory;
	}

	public void setBiddingHistory(List<Double> biddingHistory) {
		this.biddingHistory = biddingHistory;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", biddingHistory=" + biddingHistory + "]";
	}
	
	
}
