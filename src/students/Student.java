package students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DatabaseMethods;

public class Student
{
	public static ArrayList<Student> students = new ArrayList<Student>();
	
	public String name;
	public String age;
	public String school;
	public String grade;
	public String id;
	
	public Student(String name, String age, String school, String grade, String id)
	{
		this.name = name;
		this.age = age;
		this.school = school;
		this.grade = grade;
		this.id = id;
	}
	
	public Student()
	{
	}
		
	public static void registerStudent(String name, String age, String school, String grade, String id)
	{
		students.add(new Student(name,age,school,grade, id));
		System.out.println("Student Registered!");
	}
	
	public static void deleteStudent(int id)
	{
		
	}
	
	public int compareTo(Student student, String type) 
	{
		switch (type) {
		case "name": 
			return(this.getName().compareToIgnoreCase(student.getName()));
		case "age": 
			return (Integer.compare(Integer.valueOf(this.getAge()), Integer.valueOf(student.getAge())));
		case "school": 
			return (this.getSchool().compareToIgnoreCase(student.getSchool()));
		case "grade": 
			return (Integer.compare(Integer.valueOf(this.getGrade()), Integer.valueOf(student.getGrade())));
		default: 
			return 0;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAge()
	{
		return age;
	}
	
	public String getSchool()
	{
		return school;
	}
	
	public String getGrade()
	{
		return grade;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String toString()
	{
		return name;
	}
	
	public int toInt()
	{
		return Integer.valueOf(id);
	}
	
	public static void registerStudent(String name, String age, String grade, String school) 
	{
		try 
		{
			Connection conn = DatabaseMethods.connect();
			PreparedStatement prep = conn.prepareStatement("INSERT INTO tbl_students (Name, Age, Grade, School) values(?, ?, ?, ?);");
			prep.setString(1, name);
			prep.setInt(2, Integer.valueOf(age));
			prep.setInt(3, Integer.valueOf(grade));
			prep.setString(4, school);
			//prep.setInt(5, id);
			prep.execute();
			
			System.out.println("Registered Student");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
