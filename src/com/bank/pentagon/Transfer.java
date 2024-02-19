package com.bank.pentagon;

import java.sql.*;
import java.util.*;

public class Transfer {

	public static void transfer() 
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps1 = null,ps2 = null;
		

		String debit = "UPDATE PENTAGON SET BALANCE=BALANCE-? Where ACCNO = ?";
		String credit = "UPDATE PENTAGON SET BALANCE=BALANCE+? Where ACCNO = ?";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"+"user=root&password=CalcNdc@123");
			System.out.println("Enter the benificiary Account number : ");
			int acc2 = sc.nextInt();
			System.out.println("Enter the amount to be transferred:");
			double amt = sc.nextDouble();
			System.out.println("Enter your account number : ");
			int acc1 = sc.nextInt();
			ps1 = con.prepareStatement(debit);
			ps1.setInt(2, acc1);
			ps1.setDouble(1, amt);
			ps1.executeUpdate();
			ps2 = con.prepareStatement(credit);
			ps2.setInt(2, acc2);
			ps2.setDouble(1, amt);
			ps2.executeUpdate();
			System.out.println("The amount of Rs"+amt+"is successfully transfered to "+acc2);
			 CustomerInterface.showDetails();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps2!=null) 
			{
				try {
					ps2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps1!=null) 
			{
				try {
					ps1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				if(con!=null) 
				{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				sc.close();		

		}
	}

}
