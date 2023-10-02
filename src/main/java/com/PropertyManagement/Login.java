package com.PropertyManagement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req , HttpServletResponse res) {
		
		
		
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		
		User user = Validate.login(email, password);
		
		HttpSession session = req.getSession();
		
		session.setAttribute("user", user);
		
		try {
			res.sendRedirect("profile.jsp");
		} catch (Exception e) {
			System.out.println("Something wrong with redirect " + e.getMessage());
		}
	}
	
}
