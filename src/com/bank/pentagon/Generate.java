package com.bank.pentagon;
import java.sql.*;
import java.util.*;
public class Generate {

	public static void generatePIN() 
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		String gpin = "UPDATE PENTAGON SEt PIN=? Where ACCNO = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"+"user=root&password=CalcNdc@123");
			ps = con.prepareStatement(gpin);
			System.out.println("Enter the account nnumber : ");
			int acc=sc.nextInt();
		    ps.setInt(2, acc);
		    System.out.println("Enter the 4 digit pin to be set : ");
		    int pin =sc.nextInt();
		    if(pin>999&&pin<10000)
		    {
		    	ps.setInt(1, pin);
		    	ps.executeUpdate();
		    	System.out.println("PIN generated Successfully");
		    	 CustomerInterface.showDetails();
		    }
		    else
		    {
		    	System.out.println("You have entered Invalid pin");
		    }
		   
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
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
