package sheridantrafalgar.controller;

import java.io.Console;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sheridantrafalgar.dao.StudentDAO;
import sheridantrafalgar.dao.StudentDAOImplementation;
import sheridantrafalgar.model.Student;

public class StudentController extends HttpServlet {
	
	private StudentDAO dao;	
	private String gpastr; //GPA AS STRING
	private double gpadlb; //GPA AS DOUBLE
	
	public static final String LIST_STUDENT = "/listStudent.jsp";
	public static final String INSERT_OR_EDIT = "/student.jsp";
	
	public StudentController() {
		
		dao = new StudentDAOImplementation();
		
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
			forward = LIST_STUDENT;
			
			//Set the ID value to be the one from the Request
			int studentId = Integer.parseInt(req.getParameter("studentid"));
			
			//Call in the DAO method, passing the appropriate value;
			dao.deleteStudent(studentId);
			
			//Set the add the new list for of values to the request
			req.setAttribute("students", dao.getAllStudents());
			
		}else if(action.equalsIgnoreCase("edit")) {
			//Set which will be the output page.
			forward = INSERT_OR_EDIT;
			
			//Set the ID value to be the one from the Request
			int studentId = Integer.parseInt(req.getParameter("studentid"));
			
			Student student = dao.getStudentById(studentId);
			
			//Set the new list of attributes to the Request;
			req.setAttribute("students", student);
			
			
		}else if(action.equalsIgnoreCase("insert")) {
			
			//Set which will be the output page.
			forward = INSERT_OR_EDIT;
			
		}else if(action.equalsIgnoreCase("searchstudentsfromcity")) {
				
			//Set which will be the output page.
			//forward = LIST_STUDENTS_FROM_PROGRAM;
			forward = LIST_STUDENT;	
			//Set the Parameter to the one that will be used to filter
			String cityRequest = req.getParameter("city");
			System.out.println(cityRequest);
			//Set the list of attributes to the result of the DAO method.
			req.setAttribute("students", dao.getStudentByCity(cityRequest));
			
			
		}else if(action.equalsIgnoreCase("searchstudentswithgpa")) {
			
			//Set which will be the output page.
			//forward = LIST_STUDENTS_WITH_GPA;
			forward = LIST_STUDENT;
			//Set the Parameter to the one that will be used to filter
			String gpaRequest = req.getParameter("gpa");
			
			//Parse the result from string to Double
			double gpadblRequest = Double.parseDouble(gpaRequest);
			
			//Set the list of attributes to the result of the DAO method.
			req.setAttribute("students", dao.getStudentByGpa(gpadblRequest));
			
		}else {
			
			//Set which will be the Output Page
			forward = LIST_STUDENT;
			
			//Dump the Query into a Table for the user;
			req.setAttribute("students", dao.getAllStudents());
			
			
		}
		
		//Dispatch to the assigned page
		RequestDispatcher view = req.getRequestDispatcher(forward);
		
		//fire the view object
		view.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = new Student();

		student.setFirstname(req.getParameter("firstname"));
		student.setLastname(req.getParameter("lastname"));
		student.setCity(req.getParameter("city"));
		student.setProvince(req.getParameter("province"));
		student.setPostalcode(req.getParameter("postalcode"));

		
		//valueOf or try-catch block
		gpastr = req.getParameter("gpa");
		double gpadbl;
		try{
			gpadbl = Double.parseDouble(gpastr);
		} catch(NumberFormatException e){
			gpadbl = Double.parseDouble(gpastr);
			throw new RuntimeException(gpadbl + " is not a number");
		}
		
		//double gpadbl = Double.parseDouble(gpastr);
		student.setGpa(gpadbl);
		
//		String studentId = request.getParameter("ID");
		String studentId = req.getParameter("studentId");
		
		if(studentId == null || studentId.isEmpty())
			dao.addStudent(student);
		else {
			student.setStudentid(Integer.parseInt(studentId));
			dao.updateStudent(student);
		}
		
		RequestDispatcher view = req.getRequestDispatcher(LIST_STUDENT);
		req.setAttribute("students", dao.getAllStudents());
		view.forward(req, resp);
	}

}
