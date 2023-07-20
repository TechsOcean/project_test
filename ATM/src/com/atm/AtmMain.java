package com.atm;

import java.util.Scanner;

public class AtmMain {
	public static void main(String[] args)
	{
		Account head = null;
		Integer acc;
		Integer pin;
		double amount;
		
		/*
		 * to access all the services: account creation, check balance, deposit, withdraw;
		*/
		AtmServices services = new AtmServices();
		
		
		Integer choice = null;
		do {
			//displaying options
			System.out.println("1. Create Account");
			System.out.println("2. Check Balance");
			System.out.println("3. Deposit");
			System.out.println("4. Widraw");
			System.out.println("5. Exit");
			
			
			//input choice from user;
			System.out.print("Enter Your Choice: ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			
			switch(choice)
			{
			//account creation;
			case 1:
				System.out.print("Enter Account number : ");
				acc = sc.nextInt();
				System.out.println("Set Pin : ");
				pin = sc.nextInt();
				head = services.createAccount(acc, pin, head);
				System.out.println("create accouunt successfully");
				break;
				
			//check balance
			case 2:
				System.out.print("Enter your account number : ");
				acc = sc.nextInt();
				System.out.println("Enter your pin : ");
				pin = sc.nextInt();
				services.checkBalance(acc, pin, head);
				break;
				
			//deposit cash
			case 3:
				System.out.print("Enter your account number : ");
				acc = sc.nextInt();
				System.out.print("Enter the amount you want to deposit : ");
				amount = sc.nextInt();
				services.depositCash(acc, amount, head);
				break;
				
			//withdraw cash
			case 4:
				System.out.print("Enter Your account number : ");
				acc = sc.nextInt();
				System.out.print("Enter Your account pin : ");
				pin = sc.nextInt();
				System.out.print("Enter the amount : ");
				amount = sc.nextInt();
				
				System.out.println("acc:"+acc+" pin:"+pin+" amount:"+amount);
				services.withdrawCash(acc, pin, amount, head);
				break;
				
			//exit
			case 5:
				System.out.println("visit again!!");
				sc.close();
				break;
			}
		}
		while(choice != null && choice!=5);
	}
}
