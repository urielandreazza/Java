package com.Calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PVEfficiencyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, 
						 HttpServletResponse resp) 
						throws ServletException, IOException {
		
		//creates an instance of the PrintWriter Object
		PrintWriter out = resp.getWriter();
		
		//Set the Content Type
		resp.setContentType("text/html");
		
		//Print the result for the user
		out.println("<a class=\"vglnk\""
				+"href=\"http://photovoltaic-software.com/pvgis.php\""
				+"rel=\"nofollow\">"
				+"<span>Learn More About Solar Energy</span><span>.</span><span>com</span></a>");
		
		//close the PrintWriter Stream
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
