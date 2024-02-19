package com.bank.pentagon;

import java.sql.*;
import java.util.*;

public class Withdraw {

	public static void withdraw()
	{
//		double bal = 0.0;
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps1 = null,ps2=null;
		ResultSet rs = null;
		String wdraw = "UPDATE PENTAGON SET BALANCE=BALANCE-? Where ACCNO = ?";
		String check = "SELECT * FROM PENTAGON WHERE ACCNO=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"+"user=root&password=CalcNdc@123");

			ps1 = con.prepareStatement(wdraw);
			System.out.println("Enter the account number : ");
			int acc=sc.nextInt();
		    ps1.setInt(2, acc);
			System.out.println("Enter the amount to be withdraw :");
			double amt = sc.nextDouble();
			ps1.setDouble(1, amt);
//			ps.executeUpdate();	
			ps2 = con.prepareStatement(check);
			ps2.setInt(1, acc);
            rs=ps2.executeQuery();
            
            if(rs.next()) 
            {
                   
               double balance = rs.getDouble(4);
            
			if(amt <= balance) {

               ps1.executeUpdate();
               System.out.println("Amount of Rs" + amt + " has been debited from your account");

           } else {
               System.out.println("Insufficient balance.");
           }
            }
            

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


