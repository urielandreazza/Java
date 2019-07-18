package sheridantrafalgar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sheridantrafalgar.model.Pojo;
import sheridantrafalgar.util.DBUtil;

public class DAOImplementation implements DAO {
	
	//Pull the information necessary to create the connection to the Database, and save it on a variable;
	private Connection conn;
	
	public static final String TABLE = "flights";
	
	public DAOImplementation() {
		
		conn = DBUtil.getConnection();
		
	}
	
	//Query all the Table to be dumped in a table for the User
	@Override
	public List<Pojo> getAllRecords() {
		
		//Initiate a new List of the Object that will be queried;
		List<Pojo> pojos = new ArrayList<Pojo>();
		
		//Try Querying the Database
		try{
			
			//Create the connection with the Database
			Statement stmt = conn.createStatement();
			
			String Query = "SELECT * from "+TABLE;
			
			//Query the Database and saves the Result Set
			ResultSet rs = stmt.executeQuery(Query);

			
			//Iterate over the result set, and save them in the appropriate property
			//of the related object.
			while(rs.next()) {
				
				//Initialize a new instance of the appropriate Object
				Pojo bean = new Pojo ();
				
				//Add the values to the properties;
				bean.setFlightid(rs.getInt("flightID"));
				bean.setFlightno(rs.getString("flightNO"));
				bean.setDepartingcity(rs.getString("departingCity"));
				bean.setDestination(rs.getString("destination"));
				bean.setDistanceinkm(rs.getInt("distanceInKm"));
				bean.setDailyflights(rs.getString("dailyFlights"));
				
				//Adds the object to the list;
				pojos.add(bean);
				
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
		return pojos;
	}

	//Add record to the Table
	@Override
	public void addRecord(Pojo bean) {
		try {
			//Define the Query that will be run on the DB, each '?' is one of the values that will be added to the Query
			String query = "insert into "+TABLE+"(flightNO, departingCity,destination,distanceInKm, dailyFlights)values(?,?,?,?,?)";
			
			//Creates the Connection to the Database
			PreparedStatement ps = conn.prepareStatement(query);
			
			//Set the values for the '?' on the query
			ps.setString(1,  bean.getFlightno());
			ps.setString(2,  bean.getDepartingcity());
			ps.setString(3,  bean.getDestination());
			ps.setInt(4, bean.getDistanceinkm());
			ps.setString(5, bean.getDailyflights());
			
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
	public void deleteRecord(int beanId) {

		try {
			//Define the Statement that will be run on the DB, each '?' is one of the values that will be added to the Statement
			String query = "delete from "+TABLE+" where flightID=?";
			
			//Creates the Connection to the Database
			PreparedStatement ps = conn.prepareStatement(query);
			
			//Set the Value of the '?'
			ps.setInt(1, beanId);
			
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
	public void updateRecord(Pojo bean) {
		try {
			//Define the Statement that will be run on the DB, each '?' is one of the values that will be added to the Statement
			String query = "UPDATE "+TABLE+" SET flightNo=?, departingCity=?, destination=?, distanceInKm=?, dailyFlights=? WHERE flightID=?";
			
			//Creates the Connection to the Database;
			PreparedStatement ps = conn.prepareStatement(query);
			
			//Set the values for the '?' on the statement
			ps.setString(1,  bean.getFlightno());
			ps.setString(2,  bean.getDepartingcity());
			ps.setString(3,  bean.getDestination());
			ps.setInt(4, bean.getDistanceinkm());
			ps.setString(5, bean.getDailyflights());
			ps.setInt(6,  bean.getFlightid());
			
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
	public Pojo getRecordById(int beanId) {
		
		//Creates a new instance of the Appropriate Object
		Pojo bean = new Pojo();
		try {
			//Prepare the Query that will be run on the DB.
			String query = "select * from "+TABLE+" where flightID=?";
			
			//Creates the Connection to the DB.
			PreparedStatement ps = conn.prepareStatement(query);
			
			//Set the Value of the '?' on the Statement
			ps.setInt(1, beanId);
			
			//Execute the Query and save it on the ResultSet
			ResultSet rs = ps.executeQuery();
			
			//Iterate over the Result Set and add the values of the query to the relative properties on the Object 
			//If query is running using the Primary Key Which is unique, is there a necessity to iterate of the RS ????
			while(rs.next()) {
				bean.setFlightid(rs.getInt("flightID"));
				bean.setFlightno(rs.getString("flightNO"));
				bean.setDepartingcity(rs.getString("departingCity"));
				bean.setDestination(rs.getString("destination"));
				bean.setDistanceinkm(rs.getInt("distanceInKm"));
				bean.setDailyflights(rs.getString("dailyFlights"));
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
		return bean;
	}

	//Query the Table by Program [Change for other Projects]
	@Override
	public List<Pojo> getRecordByString(String stringValue) {
		
		//Creates a List of the Desired Object
		List<Pojo> pojos = new ArrayList<Pojo>();

		//Try Block in case something goes wrong;
		try {
			//Prepare the Query
			String query = "select * from "+TABLE+" where destination=?";
			PreparedStatement ps = conn.prepareStatement(query);

			//Set the Value of the '?' on the statement
			ps.setString(1, stringValue);
			
			//Execute the Statement and save the result on the Result Set
			ResultSet rs = ps.executeQuery();
			

			//Iterate over the Result Set
			while(rs.next()) {
				//Creates an instance of the desired Object
				Pojo bean = new Pojo();
				
				//Record each value on the Object Properties
				bean.setFlightid(rs.getInt("flightID"));
				bean.setFlightno(rs.getString("flightNO"));
				bean.setDepartingcity(rs.getString("departingCity"));
				bean.setDestination(rs.getString("destination"));
				bean.setDistanceinkm(rs.getInt("distanceInKm"));
				bean.setDailyflights(rs.getString("dailyFlights"));
								
				
				
				//Add the Object to the List of Objects
				pojos.add(bean);
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
		return pojos;
	}	
}
