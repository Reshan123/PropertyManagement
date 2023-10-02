package com.PropertyManagement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		float amountReq =  Float.parseFloat(request.getParameter("amount"));
		int monthReq = Integer.parseInt(request.getParameter("month"));
		float interestReq = Float.parseFloat(request.getParameter("interest"));
		
		float interest = amountReq * interestReq/100;
		float pay = amountReq + interest;
		int month = (int) pay / monthReq;
		
		int intInterest = (int) interest;
		int intPay = (int) pay;
		
		request.setAttribute("amount", amountReq);
		request.setAttribute("tDuration", monthReq);
		request.setAttribute("intrestRate", interestReq);
		request.setAttribute("interest", intInterest);
		request.setAttribute("totalPay", intPay);
		request.setAttribute("payPerMonth", month);
		
		RequestDispatcher reqDis = request.getRequestDispatcher("calc.jsp");
		reqDis.forward(request, response);
		
	}

}
