package com.bank.pentagon;

import java.sql.*;
import java.util.*;

public class Deposit 
{
	public static void deposit() 
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		String dep = "UPDATE PENTAGON SET BALANCE=BALANCE+? Where ACCNO = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"+"user=root&password=CalcNdc@123");
			ps = con.prepareStatement(dep);
			System.out.println("Enter the account nnumber : ");
			int acc=sc.nextInt();
		    ps.setInt(2, acc);
			System.out.println("Enter the amount to be deposited :");
			double amt = sc.nextDouble();
			ps.setDouble(1, amt);
			ps.executeUpdate();	
			System.out.println("Amount of Rs "+amt+" has been deposited to your account successfully");
			 CustomerInterface.showDetails();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null) 
			{
				try {
					ps.close();
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
