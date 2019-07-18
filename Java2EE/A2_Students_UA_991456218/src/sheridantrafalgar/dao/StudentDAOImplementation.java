package sheridantrafalgar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sheridantrafalgar.model.Student;
import sheridantrafalgar.util.DBUtil;

public class StudentDAOImplementation implements StudentDAO {
	
	//Pull the information necessary to create the connection to the Database, and save it on a variable;
	private Connection conn;
	
	public StudentDAOImplementation() {
		
		conn = DBUtil.getConnection();
		
	}
	
	//Query all the Table to be dumped in a table for the User
	@Override
	public List<Student> getAllStudents() {
		
		//Initiate a new List of the Object that will be queried;
		List<Student> students = new ArrayList<Student>();
		
		//Try Querying the Database
		try{
			
			//Create the connection with the Database
			Statement stmt = conn.createStatement();
			
			
			//Query the Database and saves the Result Set
			ResultSet rs = stmt.executeQuery("SELECT studentID, fname, lname, city, province, postalcode, CAST(GPA as DECIMAL(3,2)) as GPA from students");

			
			//Iterate over the result set, and save them in the appropriate property
			//of the related object.
			while(rs.next()) {
				
				//Initialize a new instance of the appropriate Object
				Student stu = new Student ();
				
				//Add the values to the properties;
				stu.setStudentid(rs.getInt("studentID"));
				stu.setFirstname(rs.getString("fName"));
				stu.setLastname(rs.getString("lName"));
				stu.setCity(rs.getString("city"));
				stu.setProvince(rs.getString("province"));
				stu.setPostalcode(rs.getString("postalcode"));
				stu.setGpa(rs.getDouble("GPA"));
				
				//Adds the object to the list;
				students.add(stu);
				
			}
			
			//Close the Result Set Data Stream;
			rs.close();
			
			//Close the Database connection;
			stmt.close();
			
			
		}catch(SQLException e){
			//Spit out the error in case it goes wrong.
			e.printStackTrace();
		}
		
		//Returns the list of the object
		return students;
	}

	//Add record to the Table
	@Override
	public void addStudent(Student stu) {
		try {
			//Define the Query that will be run on the DB, each '?' is one of the values that will be added to the Query
			String query = "insert into students(fname, lname, city, province, postalcode,GPA)values(?,?,?,?,?,?)";
			
			//Creates the Connection to the Database
			PreparedStatement ps = conn.prepareStatement(query);
			
			//Set the values for the '?' on the query
			ps.setString(1,  stu.getFirstname());
			ps.setString(2,  stu.getLastname());
			ps.setString(3,  stu.getCity());
			ps.setString(4,  stu.getProvince());
			ps.setString(5,  stu.getPostalcode());
			ps.setDouble(6, stu.getGpa());
						
			//Execute the query on the Database
			ps.executeUpdate();
			
			//Close the Connection to the Database
			ps.close();
		} catch(SQLException e) {
			
			//Spit out the error in case it goes wrong.
			e.printStackTrace();
		}
	}

	//Delete Record from Table
	@Override
	public void deleteStudent(int studentId) {

		try {
			//Define the Statement that will be run on the DB, each '?' is one of the values that will be added to the Statement
			String query = "delete from students where studentID=?";
			
			//Creates the Connection to the Database
			PreparedStatement ps = conn.prepareStatement(query);
			
			//Set the Value of the '?'
			ps.setInt(1, studentId);
			
			//Execute the statement on the Database
			ps.executeUpdate();
			
			//Close the Connection to the Database
			ps.close();
		} catch(SQLException e) {
			
			//Spit out the error in case it goes wrong.
			e.printStackTrace();
		}
	}

	//Update Table
	@Override
	public void updateStudent(Student stu) {
		try {
			//Define the Statement that will be run on the DB, each '?' is one of the values that will be added to the Statement
			String query = "UPDATE students SET fname=?, lname=?, city=?, province=?, postalcode=?, GPA=? WHERE studentID=?";
			
			//Creates the Connection to the Database;
			PreparedStatement ps = conn.prepareStatement(query);
			
			//Set the values for the '?' on the statement
			ps.setString(1,  stu.getFirstname());
			ps.setString(2,  stu.getLastname());
			ps.setString(3,  stu.getCity());
			ps.setString(4,  stu.getProvince());
			ps.setString(5,  stu.getPostalcode());
			ps.setDouble(6, stu.getGpa());
			ps.setInt(7,  stu.getStudentid());
			
			//Execute the Statement on the Database
			ps.executeUpdate();
			
			//Close the Connection to the Database;
			ps.close();
		} catch (SQLException e) {
			
			//Spit out the error in case it goes wrong.
			e.printStackTrace();
		}	
	}

	//Query Table by ID
	@Override
	public Student getStudentById(int studentId) {
		
		//Creates a new instance of the Appropriate Object
		Student stu = new Student();
		try {
			//Prepare the Query that will be run on the DB.
			String query = "select * from students where studentID=?";
			
			//Creates the Connection to the DB.
			PreparedStatement ps = conn.prepareStatement(query);
			
			//Set the Value of the '?' on the Statement
			ps.setInt(1, studentId);
			
			//Execute the Query and save it on the ResultSet
			ResultSet rs = ps.executeQuery();
			
			//Iterate over the Result Set and add the values of the query to the relative properties on the Object 
			//If query is running using the Primary Key Which is unique, is there a necessity to iterate of the RS ????
			while(rs.next()) {
				stu.setStudentid(rs.getInt("studentID"));
				stu.setFirstname(rs.getString("fName"));
				stu.setLastname(rs.getString("lName"));
				stu.setCity(rs.getString("city"));
				stu.setProvince(rs.getString("province"));
				stu.setPostalcode(rs.getString("postalcode"));
				stu.setGpa(rs.getDouble("GPA"));
			}
			
			//Close the Data Stream from the Result Set
			rs.close();
			
			//Close the Connection with the Database
			ps.close();
		} catch (SQLException e) {
			
			//Spit out the error in case it goes wrong.
			e.printStackTrace();
		}
		
		//Return the Object as the result of the Method;
		return stu;
	}

	//Query the Table by Program [Change for other Projects]
	@Override
	public List<Student> getStudentByCity(String city) {
		
		//Creates a List of the Desired Object
		List<Student> students = new ArrayList<Student>();

		//Try Block in case something goes wrong;
		try {
			//Prepare the Query
			String query = "select * from students where city=?";
			PreparedStatement ps = conn.prepareStatement(query);

			//Set the Value of the '?' on the statement
			ps.setString(1, city);
			
			//Execute the Statement and save the result on the Result Set
			ResultSet rs = ps.executeQuery();
			

			//Iterate over the Result Set
			while(rs.next()) {
				//Creates an instance of the desired Object
				Student stu = new Student();
				
				//Record each value on the Object Properties
				stu.setStudentid(rs.getInt("studentID"));
				stu.setFirstname(rs.getString("fName"));
				stu.setLastname(rs.getString("lName"));
				stu.setCity(rs.getString("city"));
				stu.setProvince(rs.getString("province"));
				stu.setPostalcode(rs.getString("postalcode"));
				stu.setGpa(rs.getDouble("GPA"));
				
				
				//Add the Object to the List of Objects
				students.add(stu);
			}
			//Close the Data Stream from the Result Set
			rs.close();
			
			//Close the Connection to the Database
			ps.close();
		} catch (SQLException e) {
			
			//Spit out the error in case something goes wrong
			e.printStackTrace();
		}
		
		
		//Return the List of the Object as the result of the Method
		return students;
	}

	//Query the Table by GPA [Change for other Projects]
	@Override
	public List<Student> getStudentByGpa(double gpa) {
		
		//Creates a List of the Desired Object
		List<Student> students = new ArrayList<Student>();

		//Try Block in case something goes Wrong
		try {
			//Prepare the query to be run on the Database
			String query = "select * from students where GPA=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			//Set the Value of the '?' of the Statement
			ps.setDouble(1, gpa);
			
			//Runs the Query on the Database and store the result on the Result Set;
			ResultSet rs = ps.executeQuery();
			
			//Iterate over the result set
			while(rs.next()) {
				
				//Creates an instance of the Desired Object
				Student stu = new Student();
				
				//Save the Values of the Result Set on the Properties of the instanciate Object
				stu.setStudentid(rs.getInt("studentID"));
				stu.setFirstname(rs.getString("fName"));
				stu.setLastname(rs.getString("lName"));
				stu.setCity(rs.getString("city"));
				stu.setProvince(rs.getString("province"));
				stu.setPostalcode(rs.getString("postalcode"));
				stu.setGpa(rs.getDouble("GPA"));
				
				//Adds the Object to the Object List
				students.add(stu);
			}
			
			//Close the Result Set Data Stream;
			rs.close();
			
			//Close the Connection to the Database;
			ps.close();
			
		} catch (SQLException e) {
			
			//Spit out the Error in case something goes wrong;
			e.printStackTrace();
		}
		
		//Return the List of the Desired Object as the result of the Method;
		return students;
	}

	
	
}
