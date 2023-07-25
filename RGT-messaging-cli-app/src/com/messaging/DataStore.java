package com.messaging;

public class DataStore {
	
	private static int id;
	
	public DataStore() {
		this.id = 0;
	}
	
	public void saveData() {
		
	}
	
	public void loadData() {
		
	}
	
	public int generateTweetId() {
		return ++id;
	}
}
