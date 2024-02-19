package com.bank.pentagon;

import java.sql.*;
import java.util.Scanner;

public class CustomerInterface 
{
	public static void showDetails()
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Wlecome to Pentagon UI");
		System.out.println("Select an Option : ");
		System.out.println("1. Check Account Balance");
		System.out.println("2. Deposit");
		System.out.println("3. withDraw");
		System.out.println("4. Transfer the amount");
		System.out.println("5. Generate PIN");
		System.out.println("6. Go Back to Main MENU");
		
		
		int choice = 0;
		System.out.println("Enter your choice:");
		 choice =sc.nextInt();
		switch(choice)
		{
		case 1:
			CheckBalance.checkBalance();
			break;
		case 2:
			Deposit.deposit();
			break;
		case 3:
			Withdraw.withdraw();
			break;
		case 4:
			Transfer.transfer();
			break;
		case 5:
			Generate.generatePIN();
			break;
		case 6:
			System.out.println("Returning to Main MENu");

			break;
		default:
			System.out.println("Invalid Choice");
				
		
		}
		Bank.main(null);

	}
		


	






	// case 1
	
}
