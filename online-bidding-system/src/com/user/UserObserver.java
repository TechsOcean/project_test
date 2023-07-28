package com.user;

import com.item.Item;

public class UserObserver implements Observer {

	private User user;
	
	
	
	public UserObserver(User user) {
		super();
		this.user = user;
	}



	@Override
	public void update(Item item) {
		// TODO Auto-generated method stub

	}

}
