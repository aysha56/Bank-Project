package com.bank.pentagon;

import java.sql.*;
import java.util.*;

public class CheckBalance {
	public static void checkBalance() 
	{  
		
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String bal = "Select  * from PENTAGON WHERE ACCNO=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"+"user=root&password=CalcNdc@123");
			ps = con.prepareStatement(bal);
			System.out.println("Enter the account nnumber : ");
			int acc=sc.nextInt();
		    ps.setInt(1, acc);
		    rs = ps.executeQuery();
		    if(rs.next())
		    { 
		    	double balance = rs.getDouble(4);
		    	String name = rs.getString(2);
		    	System.out.println("Deaar "+name+" Your Balance is Rs"+balance);
		    }
		    else
		    {
		    	System.out.println("Invalid account number");
		    }
		    
		    CustomerInterface.showDetails();

		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
					sc.close();		
					}
		
	}
	
	
}

}
