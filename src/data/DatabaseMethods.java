package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.PreparedStatement;
import students.Student;
import util.IO;

public class DatabaseMethods 
{
	public static Connection connect() 
	{
		String url = "jdbc:sqlite:rsc/tbl_students.db";
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
	
	public static void printStudents(ArrayList<Student> students)
	{
		for (Student student : students)
		{
			System.out.println
			(
					student.name + "\t" +
					student.age + "\t" +
					student.grade + "\t" +
					student.school + "\t" +
					student.id + "\t"
			);
		}
	}
	
	public static void consoleStudents()
	{
	    String sql = "SELECT name, age, grade, school, id FROM tbl_students";
	     
	    try (Connection conn = DatabaseMethods.connect();
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
	
	public static void addStudent(String name, int age, int grade, String school, int id) 
	{
		try 
		{
			Connection conn = DatabaseMethods.connect();
			PreparedStatement prep = conn.prepareStatement("INSERT INTO tbl_students values(?, ?, ?, ?, ?);");
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
	
	public static void removeStudent(int id)
	{
		try
		{
			Connection conn = DatabaseMethods.connect();
			PreparedStatement prep = conn.prepareStatement(
					"DELETE FROM tbl_students\n" + 
					"WHERE id = "+id+";");
			
			prep.execute();
			IO.print("Removed student");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Student> toArrayList()
	{
		ArrayList<Student> students = new ArrayList<Student>();
		
		String sql = "SELECT name, age, grade, school, id \n"
					+"FROM tbl_students";
		
		try (Connection conn = DatabaseMethods.connect();
		     Statement stmt = conn.createStatement();
		     ResultSet rs  = stmt.executeQuery(sql))
	    {
			// loop through the result set
			while (rs.next()) 
			{
				//creating a new student
				Student newStudent = new Student();
				
				//loading data into student
				newStudent.name = rs.getString("name"); 
				newStudent.age = Integer.toString(rs.getInt("age"));
				newStudent.grade = Integer.toString(rs.getInt("grade"));
				newStudent.school = rs.getString("school");
				newStudent.id = Integer.toString(rs.getInt("id"));
				
				//adding student to array list
				students.add(newStudent);
				IO.print("Added "+newStudent.name);
			}
	    } 
	    catch (SQLException e) 
	    {
	      System.out.println(e.getMessage());
	    }
		
		return students;
	}
	
	public static ArrayList<Student> sortByName(ArrayList<Student> list)
	{
		ArrayList<Student> sortedStudents = toArrayList();
		Collections.sort(sortedStudents);
		
		return sortedStudents;
	}
	
	public static ArrayList<Student> searchName(String name)
	{
		IO.print("Searching by name");
		ArrayList<Student> students = new ArrayList<Student>();
		
		String sql = "SELECT name, age, grade, school, id\n"
					+"FROM tbl_students\n"
					+"WHERE name LIKE '"+name+"%';";
		
		/*
		 * This is Leo and I love you. The question is do you love me?
		 * Of course you do :)
		 * <3
		 */
		
		try (Connection conn = DatabaseMethods.connect();
		     Statement stmt = conn.createStatement();
		     ResultSet rs  = stmt.executeQuery(sql))
	    {
			// loop through the result set
			while (rs.next()) 
			{
				//creating a new student
				Student newStudent = new Student();
				
				//loading data into student
				newStudent.name = rs.getString("name"); 
				newStudent.age = Integer.toString(rs.getInt("age"));
				newStudent.grade = Integer.toString(rs.getInt("grade"));
				newStudent.school = rs.getString("school");
				newStudent.id = Integer.toString(rs.getInt("id"));
				
				//adding student to array list
				students.add(newStudent);
				IO.print("Added "+newStudent.name);
			}
	    } 
	    catch (SQLException e) 
	    {
	      System.out.println(e.getMessage());
	    }
		return students;
	}
}