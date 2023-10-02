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
import javax.servlet.http.HttpSession;

@WebServlet("/Feature")
public class FeatureDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static String url = "jdbc:mysql://localhost:3306/realestatephp";
	static String DBusername = "root";
	static String DBpassword = "";
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		int UUid = user.getUid();
		
		List <Property> listProperty = new ArrayList<Property>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conObj = DriverManager.getConnection(url,DBusername,DBpassword);
			
			Statement statementObj = conObj.createStatement();
			String sql = "SELECT * FROM property WHERE uid =" + UUid;
			
			ResultSet resultSetObj = statementObj.executeQuery(sql);
			
			while(resultSetObj.next()) {
				System.out.print("something");
				Property property = new Property();
				
				property.setPid(resultSetObj.getInt(1));
				property.setpTitle(resultSetObj.getString(2));
				property.setpContent(resultSetObj.getString(3));
				property.setpType(resultSetObj.getString(4));
				property.setpBHK(resultSetObj.getString(5));
				property.setpSType(resultSetObj.getString(6));
				property.setpBedroom(resultSetObj.getInt(7));
				property.setpBathroom(resultSetObj.getInt(8));
				property.setpBalcony(resultSetObj.getInt(9));
				property.setpKitchen(resultSetObj.getInt(10));
				property.setpHall(resultSetObj.getInt(11));
				property.setpFloor(resultSetObj.getString(12));
				property.setpSize(resultSetObj.getInt(13));
				property.setpPrice(resultSetObj.getInt(14));
				property.setpLocation(resultSetObj.getString(15));
				property.setpCity(resultSetObj.getString(16));
				property.setpState(resultSetObj.getString(17));
				property.setpImage(resultSetObj.getString(19));
				property.setpStatus(resultSetObj.getString(25));
				property.setpDate(resultSetObj.getString(30));
				
				listProperty.add(property);
			}
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with loading driver " + e.toString());
			
		} catch (SQLException e) {
			
			System.out.println("Something wrong with Connecting to SQL server " + e.getMessage());
			
		}
		
		request.setAttribute("Property", listProperty);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("feature.jsp");
		reqDis.forward(request, response);
	}

}
