package com.phase2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class JDBC_class {
public static void main(String[] args) throws Exception {
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url ="jdbc:mysql://localhost:3306/hibernateProject";
		String uname="root";
		String password="Paballo01@";
		
		 
		
		 try {
	            Connection obj = DriverManager.getConnection(url, uname, password);
	            Statement st = obj.createStatement();
	            // Execute SQL statements with the statement
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle the SQL exception here, e.g., log the error or provide feedback to the user.
	        }	
		
		
		try {
		    Statement st = obj.createStatement();
		    // Use the statement to execute SQL queries
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle the exception appropriately, e.g., log the error or take necessary action
		} finally {
		    // Close the statement and other resources in the finally block if needed
		}
		
		
		
		String sql;
		

		
		
		
		ResultSet rs=null;
		
		sql="select *from student";
		
		rs=st.executeQuery(sql);
		
		while(rs.next())
		{
			System.out.println("class :"+rs.getInt(1));
			System.out.println("student :"+rs.getString(2));
			System.out.println("subject is :"+rs.getString(3));
			System.out.println("teacher is :"+rs.getString(3));
		}
			
		
		
		
		
		//close the connection 
		
		st.close();
		obj.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}



