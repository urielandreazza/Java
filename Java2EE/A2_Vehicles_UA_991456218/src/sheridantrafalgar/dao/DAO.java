package sheridantrafalgar.dao;

import java.util.List;
import sheridantrafalgar.model.Pojo;


public interface DAO {

	//DAO - Data Access Object
	//This is a Design Pattern ( ie, like MVC )
	//CRUD Operations + Search/Filter Operations
	//studentid is the primary key in this schema
	
	public void addRecord(Pojo pojo);
	public void deleteRecord(int beanId);
	public void updateRecord(Pojo bean);
	
	
	//Default WebApp Operation
	public List<Pojo> getAllRecords();
	public Pojo getRecordById(int studentId);
	
	//Search / Filters
	public List<Pojo> getRecordByString(String stringValue);
}
