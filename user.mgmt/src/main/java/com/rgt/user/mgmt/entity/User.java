package com.rgt.user.mgmt.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String role="ROLE_NORMAL";
	
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
}
