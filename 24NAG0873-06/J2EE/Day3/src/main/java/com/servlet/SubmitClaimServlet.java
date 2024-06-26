package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.javabean.ClaimBean;

@SuppressWarnings("serial")
@WebServlet("/submitClaim")
public class SubmitClaimServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String claimantName = request.getParameter("claimantName");
		String claimType = request.getParameter("claimType");
		double claimAmount = Double.parseDouble(request.getParameter("claimAmount"));
		ClaimBean claim = new ClaimBean();
		claim.setClaimantName(claimantName);
		claim.setClaimType(claimType);
		claim.setClaimAmount(claimAmount);
		request.setAttribute("claim", claim);
		request.getRequestDispatcher("confirmation.jsp").forward(request, response);
	}
	

}
