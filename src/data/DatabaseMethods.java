package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DatabaseMethods 
{
	public Connection connect() 
	{
		String url = "jdbc:sqlite:ExampleTest.db";
		Connection conn = null;
		
		try 
		{
			conn = DriverManager.getConnection(url);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	public void displayAll()
	{
	    String sql = "SELECT name, age, grade, school, id FROM tbl_students";
	     
	    try (Connection conn = this.connect();
	       Statement stmt = conn.createStatement();
	       ResultSet rs  = stmt.executeQuery(sql))
	    {
	       
		// loop through the result set
		while (rs.next()) 
		{
			System.out.println(rs.getString("name") + "\t" + 
			rs.getInt("age") + "\t" +
			rs.getInt("grade") + "\t" +
			rs.getString("school") + "\t" +
			rs.getInt("id"));
		}
	    } 
	    catch (SQLException e) 
	    {
	      System.out.println(e.getMessage());
	    }
	}
	
	public void addStudent(String name, int age, int grade, String school, int id) 
	{
		try 
		{
			Connection conn = this.connect();
			PreparedStatement prep = conn.prepareStatement("INSERT INTO class values(?, ?, ?, ?, ?);");
			prep.setString(1, name);
			prep.setInt(2, age);
			prep.setInt(3, grade);
			prep.setString(4, school);
			//prep.setInt(5, id);
			prep.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}