package students;

import java.util.ArrayList;

public class Student 
{
	static ArrayList<Student> students = new ArrayList<Student>();
	
	public String name;
	public String age;
	public String school;
	public String grade;
	
	public Student(String name, String age, String school, String grade)
	{
		this.name = name;
		this.age = age;
		this.school = school;
		this.grade = grade;
	}
		
	public static void registerStudent(String name, String age, String school, String grade)
	{
		students.add(new Student(name,age,school,grade));
		System.out.println("Student Registered!");
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
	
	public String toString()
	{
		return name;
	}
}
