package temp1;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public abstract class Action {
      public abstract void act(Address addr);
     
}
/*

Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
//			Class.forName("com.mysql.jdbc.Driver");
//			conn=DriverManager.getConnection
//				("jdbc:mysql://localhost:3306/school","root","root");
			
			conn=DataAccess.getConnection();
			 stmt=conn.createStatement();
			 rs=stmt.executeQuery("select * from student");
			while(rs.next())
			{
				System.out.print(rs.getString("id")+" ");
				System.out.print(rs.getString("name")+" ");
				System.out.println(rs.getString("depart"));
				
			}
		}
//		catch(ClassNotFoundException e)
//		{
//			e.printStackTrace();
//		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{	
			try
			{
				if(rs!=null)
				{
					rs.close();
					rs=null;
				}
				if(stmt!=null)
				{
					stmt.close();
					stmt=null;
				}
				if(conn!=null)
				{
					conn.close();
					conn=null;
				}
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
			
		}



*/