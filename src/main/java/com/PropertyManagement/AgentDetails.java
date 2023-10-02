package com.PropertyManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Agent")
public class AgentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static String url = "jdbc:mysql://localhost:3306/realestatephp";
	static String DBusername = "root";
	static String DBpassword = "";
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <User> listUsers = new ArrayList<User>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "SELECT * FROM user WHERE uType='agent'";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			while(resultSetObj.next()) {
				int uid = resultSetObj.getInt(1);
				String uname = resultSetObj.getString(2);
				String uemail = resultSetObj.getString(3);
				String uphone = resultSetObj.getString(4);
				String upass = resultSetObj.getString(5);
				String utype = resultSetObj.getString(6);
				String uimage = resultSetObj.getString(7);
				
				User user = new User(uid,uname,uemail,uphone,upass,utype,uimage);
				listUsers.add(user);
				
			}
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		request.setAttribute("agents", listUsers);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("agent.jsp");
		reqDis.forward(request, response);
	}

}
