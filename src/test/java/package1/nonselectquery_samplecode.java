package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class nonselectquery_samplecode {
	public static void main(String[] args) throws Throwable {
		
	
	Connection conn = null;
	 int result = 0;
	try
	{
		 Driver drievrRef = new Driver();
		/* step 1 : load/register my the data base */
		DriverManager.registerDriver(drievrRef);
		
		/* step 2: connection to database */
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("connection is done");
		
		/* step 3 : create  query statement */
			Statement stat = conn.createStatement();
			String query = "insert into project value('TY_PROJ_302','samad','12/01/2022','hayaboosa','On Going', 10)";
			
			/* step 4 : Execute the query */
		 result = stat.executeUpdate(query);
	}
	catch (Exception e)
	{
	}
	finally
	{
		if (result ==1)
		{ System.out.println("project insereted succesfully");
		}
		else
		{
			System.out.println("project is not inserted");
		}
		/* step 5 : close connection*/
		conn.close();
		System.out.println("close database connection");
		}
	}
	
	}
