package com.PropertyManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/About")
public class AboutDetails extends HttpServlet {
	
	static String url = "jdbc:mysql://localhost:3306/realestatephp";
	static String DBusername = "root";
	static String DBpassword = "";
	
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "SELECT * FROM about";
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			if(resultSetObj.next()) {
				String title = resultSetObj.getString(2);
				String content = resultSetObj.getString(3);
				String image = resultSetObj.getString(4);
				
				request.setAttribute("title", title);
				request.setAttribute("content", content);
				request.setAttribute("image", image);
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		RequestDispatcher reqDis = request.getRequestDispatcher("about.jsp");
		reqDis.forward(request, response);
		
	}

}
