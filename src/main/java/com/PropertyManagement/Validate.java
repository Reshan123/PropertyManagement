package com.PropertyManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Validate {
	
	static String url = "jdbc:mysql://localhost:3306/realestatephp";
	static String DBusername = "root";
	static String DBpassword = "";
	
	public static User login(String email , String password) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "SELECT * FROM user WHERE uemail = '" + email + "' AND upass = '" + password + "'";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			if(resultSetObj.next()) {
				int uid = resultSetObj.getInt(1);
				String uname = resultSetObj.getString(2);
				String uemail = resultSetObj.getString(3);
				String uphone = resultSetObj.getString(4);
				String upass = resultSetObj.getString(5);
				String utype = resultSetObj.getString(6);
				String uimage = resultSetObj.getString(7);
				
				User user = new User(uid,uname,uemail,uphone,upass,utype,uimage);
				return user;
			}
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;		
		
	}
	
	
	public static User findUser(int uUid) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "SELECT * FROM user WHERE uid = '" + uUid + "'";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			if(resultSetObj.next()) {
				int uid = resultSetObj.getInt(1);
				String uname = resultSetObj.getString(2);
				String uemail = resultSetObj.getString(3);
				String uphone = resultSetObj.getString(4);
				String upass = resultSetObj.getString(5);
				String utype = resultSetObj.getString(6);
				String uimage = resultSetObj.getString(7);
				
				User user = new User(uid,uname,uemail,uphone,upass,utype,uimage);
				return user;
			}
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		return null;		
		
	}
	
}

