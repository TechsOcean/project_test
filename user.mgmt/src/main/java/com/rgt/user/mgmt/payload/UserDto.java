package com.rgt.user.mgmt.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Bharat
 * UserDto is used to return the response body.
 */

@Getter
@Setter
public class UserDto implements Comparable<UserDto>{
	
	private Integer id;
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

	@Override
	public int compareTo(UserDto o) {
		return this.id-o.id;
	}
}
