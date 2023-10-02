package com.PropertyManagement;



import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
	   
	   HttpSession session = req.getSession();
	   
	   if (session.getAttribute("user") != null) {
		   	session.removeAttribute("user");
		    res.sendRedirect("index.jsp");
		    
		}
   }

}

