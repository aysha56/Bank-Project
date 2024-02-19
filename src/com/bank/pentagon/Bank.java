package com.bank.pentagon;

import java.util.Scanner;

public class Bank 
{
	public static void main(String[] args)
	{
		int choice =0 ;
		Scanner sc = new Scanner(System.in);
		while(choice!=4)
			{
			  System.out.println("=========>>>>>> Welcome to Pentagon Bank <<<<<<=========");
			  System.out.println("Select the options");
			  System.out.println("1. Employee Interface");
			  System.out.println("2. Customer Interface");
			  System.out.println("3. Exit");
              choice=sc.nextInt();
              switch(choice) 
              {
              case 1:
            	  EmployeeInterface.addCustomerDate();
            	  break;
              case 2:
            	  CustomerInterface.showDetails();
            	  break;
              case 3:
            	  System.out.println("Exiting the application, Thank you");
            	  break;
              default:
            	  System.out.println("INnvalid PIN");
              }
            }
		sc.close();
       		
	}
	

}
