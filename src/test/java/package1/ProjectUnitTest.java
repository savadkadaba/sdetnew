package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class ProjectUnitTest {
	

	public void ProjectUnitTest() throws Throwable {
		 String ProjectName = "Apple";
		  Connection conn = null;
		  try
		  {
			  Driver driverRef = new Driver();
			  
			  DriverManager.registerDriver(driverRef);
			  
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			 System.out.println("connection is done");
			 
			 Statement stat = conn.createStatement();
			  String query = "select * from project";
			  
			 ResultSet resultset = stat.executeQuery(query);
			 boolean flag = false;
			 String actProjectName;
			while(resultset.next()) {
				actProjectName = resultset.getString(4);
			if(actProjectName.equals(ProjectName)) {
				flag = true;
		  
			 
		  }
		  
	}
	
	Assert.assertTrue(flag);
		  }
		  catch (Exception e)
		  {
		  }
		  finally
		  {
			  conn.close();
			  System.out.println("close database connection");
;		  }
			  
		  }
}
