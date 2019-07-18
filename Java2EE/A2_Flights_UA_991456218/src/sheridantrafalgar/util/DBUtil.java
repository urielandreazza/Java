package sheridantrafalgar.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static Connection conn;
	
	public static Connection getConnection() {
		
		//Check if i already have a DB connection
		if(conn != null) {
			return conn;
		}
		
		//Load the db information from the Properties
		InputStream inputStream = DBUtil
									.class
									.getClassLoader()
									.getResourceAsStream("/db.properties");
		
		//Creates an instance of the Properties;
		Properties properties = new Properties();
		
		//Try block in case something goes wrong
		try {
			//Load the Properties from the Data Stream;
			properties.load(inputStream);
			
			
			//Instantiate and Save the information of the properties on the variables
			String driver = properties.getProperty("drive");
			String url= properties.getProperty("url");
			String user = properties.getProperty("user");
			String pw = properties.getProperty("password");
			
			
			//I Don't Know what this does, sorry :(
			Class.forName(driver);
			
			
			//Creates the Connection with the Database
			conn = DriverManager.getConnection(url,user,pw);
			
		}catch(IOException e){
			
			//Spit out an error in case something goes wrong
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			
			//Spit out an error in case something goes wrong
			e.printStackTrace();
		}catch(SQLException e){
			
			//Spit out an error in case something goes wrong
			e.printStackTrace();
		}
		
		
		//Returns the connection to the Database as the result of the method
		return conn;
	}
	
	//Close the Connection with the Database
	public static void closeConection(Connection toBeClosed) {
		if(toBeClosed == null) {
			return;
					}
		
		try {
			toBeClosed.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
}
