package com.atm;

public class AtmServices {
	
	// to print all the accounts details.
	public void showAccounts(Account head)
	{
		while(head!=null)
		{
			System.out.println(head.acc+" "+head.pin+" "+head.balance);
			head = head.nextAcc;
		}
		return;
	}
	
	//for creating new account;
	public Account createAccount(Integer acc, Integer pin, Account head)
	{
		Account new_user = new Account(acc,pin);
		Account first_user;
		if(head == null)
		{
			head = new_user;
			return new_user;
		}
		else
		{
			first_user = head;
			Account last = head;
			while(head!=null)
			{
				last = head;
				head = head.nextAcc;
			}
			last.nextAcc = new_user;
			return first_user;
		}
	}
	
	public void checkBalance(Integer acc, Integer pincode, Account head)
	{
		while(head!=null)
		{
			if(head.acc.compareTo(acc) == 0)
			{
				if(head.pin.compareTo(pincode) == 0)
				{
					System.out.println("your acc balance is : "+head.balance);
					return;
				}
				else
				{
					System.out.println("pin is incorrect");
					return;
				}	
			}
			head = head.nextAcc;
		}
		System.out.println("please check account number or pin");
		return;
	}
	
	public void depositCash(Integer acc, double amount, Account head)
	{
		while(head!=null)
		{
			if(head.acc.compareTo(acc)==0)
			{
				head.balance += amount;
				System.out.println("cash deposit successfully, updated balance : "+head.balance);
				return;
			}
			head = head.nextAcc;
		}
		System.out.println("account not found");
		return;
	}
	
	public void withdrawCash(Integer acc, Integer pin, double amount, Account head)
	{
		while(head!=null)
		{
			if(head.acc.compareTo(acc)==0 && head.pin.compareTo(pin)==0)
			{
				if(head.balance>=amount)
				{
					head.balance -= amount;
					System.out.println("withdraw successfully, updated balance : "+head.balance);
					return;
				}
				else
				{
						System.out.println("insufficient balance!!");
						return;
				}
			}
			head = head.nextAcc;
		}
		System.out.println("withdraw fail, check account number or pin!!");
	}
}
