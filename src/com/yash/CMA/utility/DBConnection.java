package com.yash.CMA.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	
	
	public static Connection connection() {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/contactapplication";
			 con=DriverManager.getConnection(url,"root","root");
			//String sql="select * from employees";
			//PreparedStatement pstmt=con.prepareStatement(sql);
			//ResultSet rset=pstmt.executeQuery();	
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}	
	}
	
	

