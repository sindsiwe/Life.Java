package DBCon;

/**
 * Imported Java classes to be used  
 */
import java.sql.*;

public class ConnectDB 
{
	/**
	 * Declaring instance variable 
	 */
	static final String db_Driver = "com.mysql.jdbc.Driver";
	static final String db_URL = "jdbc:mysql//localhost/bnetworkx_studio";
	static final String mySQL_user = "root";
	static final String mySQL_pass = null;
	
	/**
	 * Method for establishing mySQL Database connection 
	 */
	Connection conn;
	public void connectdb()
	{
		try 
		{
			//Directing DB connection to mySQL
			Class.forName(db_Driver);
			String dbURL = "jdbc:mysql//localhost/bnetworkx_studio";
		}
		catch(Exception con)
		{
			System.out.println("Unable to estarbish DB conncetion " + con);
			
		}//end of try & catch
		
	}//end of method 
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Method for establishing mySQL database disconnection
	 */
	public void disconnectdb()
	{
		try
		{
			//Closing database connection 
			conn.close();
		}
		catch(Exception discon)
		{
			System.out.println("Disconnection to Database not successful " + discon);
			
		}//end of try & catch
		
	}//end of method 
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
	/**
	 * Method for creating the SQL CREATE statement for the database connection 
	 */
	public ResultSet select(String mysql)
	{
		
		try
		{
			//CREATE sql statement for DB connection
			Statement state = conn.createStatement(); 
			//Return statement for executing the sql create query
			return state.executeQuery(mysql);
			
		}
		catch(Exception state)
		{
			System.err.println(state);
		}
		return null;
		
	}//end of method 

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Method for Updating connection query
	 * @return -1 at the change in connection of the database  
	 */
	public int Change(String mysql)
	{
		try
		{
			//CREATE sql statement for DB connection
			Statement state = conn.createStatement(); 
			//Return statement for executing the sql create query
			return state.executeUpdate(mysql);
			
		}
		catch(Exception state)
		{
			System.err.println(state);
		}
		//Return 
		return -1;
		
	}//end of method 

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
}//end of class
