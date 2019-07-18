package sheridantrafalgar.controller;

import java.io.Console;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sheridantrafalgar.dao.DAO;
import sheridantrafalgar.dao.DAOImplementation;
import sheridantrafalgar.model.Pojo;

public class Controller extends HttpServlet {
	
	private DAO dao;	
	private String gtmg; //gtmg AS STRING

	
	//TOMCAT 6 (older tomcat implementation was looking for this)
	//private static final long serialversionUID = 7878L;
	
	
	
	
	public static final String LIST = "/list.jsp";
	public static final String INSERT_OR_EDIT = "/record.jsp";
	
	public Controller() {
		
		dao = new DAOImplementation();
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req,
						 HttpServletResponse resp) 
						throws ServletException, IOException {

		//Receives the Action Parameter from the Initial JSP
		//When first initialized the ListStudent Action will be Called 
		//(Querying the Table and dumping all the info into a table for the user)
		String action = req.getParameter("action");
		
		//Set the forward value to empty;
		String forward ="";
		
		//Verify which action is passed on, and forward to the proper DAO Method;
		if(action.equalsIgnoreCase("delete")) {
			//Set which will be the output page.
			forward = LIST;
			
			//Set the ID value to be the one from the Request
			int beantId = Integer.parseInt(req.getParameter("pojoid"));
			
			//Call in the DAO method, passing the appropriate value;
			dao.deleteRecord(beantId);
			
			//Set the add the new list for of values to the request
			req.setAttribute("pojos", dao.getAllRecords());
			
		}else if(action.equalsIgnoreCase("edit")) {
			//Set which will be the output page.
			forward = INSERT_OR_EDIT;
			
			//Set the ID value to be the one from the Request
			int beanId = Integer.parseInt(req.getParameter("pojoid"));
			
			Pojo pojo = dao.getRecordById(beanId);
			
			//Set the new list of attributes to the Request;
			req.setAttribute("pojos", pojo);
			
			
		}else if(action.equalsIgnoreCase("insert")) {
			
			//Set which will be the output page.
			forward = INSERT_OR_EDIT;
			
		}else if(action.equalsIgnoreCase("searchbyString")) {
				
			//Set which will be the output page.
			//forward = LIST_STUDENTS_FROM_PROGRAM;
			forward = LIST;	
			//Set the Parameter to the one that will be used to filter
			String stringValue = req.getParameter("searchString");

			//Set the list of attributes to the result of the DAO method.
			req.setAttribute("pojos", dao.getRecordByString(stringValue));
			
		}else {
			
			//Set which will be the Output Page
			forward = LIST;
			
			//Dump the Query into a Table for the user;
			req.setAttribute("pojos", dao.getAllRecords());
			
		}
		
		//Dispatch to the assigned page
		RequestDispatcher view = req.getRequestDispatcher(forward);
		
		//fire the view object
		view.forward(req,resp);
	
	
	
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pojo pojo = new Pojo();

		pojo.setFlightno(req.getParameter("make"));
		pojo.setDepartingcity(req.getParameter("model"));
		pojo.setDestination(req.getParameter("enginetype"));
		pojo.setDailyflights(req.getParameter("aiassistant"));
		//valueOf or try-catch block
		gtmg = req.getParameter("gallonthousandmilesgas");
		int gtmgint;
		try{
			gtmgint = Integer.parseInt(gtmg);
		} catch(NumberFormatException e){
			gtmgint = Integer.parseInt(gtmg);
			throw new RuntimeException(gtmgint+ " is not a number");
		}
		
		//double gpadbl = Double.parseDouble(gpastr);
		pojo.setDistanceinkm(gtmgint);
		
//		String studentId = request.getParameter("ID");
		String flightID = req.getParameter("flightID");
		
		if(flightID == null || flightID.isEmpty())
			dao.addRecord(pojo);
		else {
			pojo.setFlightid(Integer.parseInt(flightID));
			dao.updateRecord(pojo);
		}
		
		RequestDispatcher view = req.getRequestDispatcher(LIST);
		req.setAttribute("pojos", dao.getAllRecords());
		view.forward(req, resp);
	}

}
