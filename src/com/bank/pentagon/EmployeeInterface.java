package com.bank.pentagon;

import java.sql.*;
import java.util.Scanner;

public class EmployeeInterface 
{
    public static void addCustomerDate()
    { 
    	Connection con = null;
    	PreparedStatement ps = null;
    	Scanner sc = new Scanner(System.in);
    	String qry1 = "INSERT INTO PENTAGON(ACCNO,NAME,PHONE)" +"VALUES(?,?,?)";
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank?"+"user=root&password=CalcNdc@123");
			System.out.println("------------>>Employee Interface>>--------------");
			System.out.println("               Welcome to pentagon  Bank             ");
			ps = con.prepareStatement(qry1);
			System.out.println("Enter the Account Number:");
			int acc = sc.nextInt();
			ps.setInt(1, acc);
			System.out.println("Enter the Customer Name:");
			String nm = sc.next();
			ps.setString(2, nm);
			System.out.println("Enter the Mobile Number:");
			Long ph = sc.nextLong();
	        ps.setLong(3, ph);
			ps.executeUpdate();
			System.out.println("Values added Successfully");
			System.out.println();
			Bank.main(null);
    	} 
    	catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
    		if(ps!=null) {
    			try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		if(con!=null) {
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
