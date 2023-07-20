package com.atm;

public class Account{
	Integer acc;
	Integer pin;
	double balance;
	
	Account nextAcc;
	
	Account()
	{
		acc = null;
		pin = null;
		balance = 0;
		nextAcc = null;
	}
	
	Account(int account)
	{
		acc = account;
		pin = null;
		balance  = 0;
		nextAcc = null;
	}
	
	Account(int account, int pincode)
	{
		acc = account;
		pin = pincode;
		balance = 0;
		nextAcc = null;
	}
	
	Account(int account, int pin, double balance)
	{
		acc = account;
		this.pin = pin;
		this.balance = balance;
		nextAcc = null;
	}
}
