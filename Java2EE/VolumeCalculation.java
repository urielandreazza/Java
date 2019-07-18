package com.volumeServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VolumeCalculation extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, 
						 HttpServletResponse resp) 
						throws ServletException, IOException {
			//Receives the data from the index.html and calculates
		    //the Volume in the Result Variable
			int  width = Integer.parseInt(req.getParameter("width"));
			int height = Integer.parseInt(req.getParameter("height"));
			int  depth = Integer.parseInt(req.getParameter("depth"));
			
			int result = width*height*depth;
				
			//Save the Volume result to the Attributes of the Request
			//and dispatch the information to result.jsp
			req.setAttribute("volume", result);
			req.getRequestDispatcher("result.jsp").forward(req, resp);
			
}
	

}