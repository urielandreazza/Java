package sheridantrafalgar.dao;

import java.util.List;
import sheridantrafalgar.model.Student;


public interface StudentDAO {

	//DAO - Data Access Object
	//This is a Design Pattern ( ie, like MVC )
	//CRUD Operations + Search/Filter Operations
	//studentid is the primary key in this schema
	
	public void addStudent(Student student);
	public void deleteStudent(int studentId);
	public void updateStudent(Student student);
	
	
	//Default WebApp Operation
	public List<Student> getAllStudents();
	public Student getStudentById(int studentId);
	
	//Search / Filters
	public List<Student> getStudentByCity(String city);
	public List<Student> getStudentByGpa(double gpa);
}
