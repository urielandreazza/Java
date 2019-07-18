package com.Calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PVCalculatorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Creates and instance of the Print Writer Object
		PrintWriter out = resp.getWriter();
		
		//Set the content type for the response
		resp.setContentType("text/html");

		//Save the Parameter from the Request to Variables
		String          pvtechnology = req.getParameter("pvtechnology");
		String              capacity = req.getParameter("capacity");
		String estimatedsystemlosses = req.getParameter("estimatedsystemlosses");		
		
		//Verify if one of the three parameters is Empty
		if (pvtechnology.isEmpty() || capacity.isEmpty() || estimatedsystemlosses.isEmpty()) {

			//Case where the one necessary of the Field is not Filled
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			
			//Append the Message to index.html prompting the user to fill the necessary items;
			out.println("<font color=red>Please enter all REQUIRED fields. The PV Calculator will be" +
						" unable to determine the effiency of the system.");
			rd.include(req, resp);
		}else {
			
			//redirect the result servlet
			out.println("<h3><p style=\"color:green\">All necessary information have been Filled</p></h3>");
			resp.sendRedirect("PVEfficiencyServlet");
		}
		
		//close the PrintWriter stream
		out.close();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
