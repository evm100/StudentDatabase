package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import students.Student;

import javax.swing.JLabel;

public class Registration extends TemplateUI
{
	private static final long serialVersionUID = 1L;
	private JTextField tName;
	private JTextField tAge;
	private JTextField tSchool;
	private JTextField tGrade;
	
	private String name;
	private String age;
	private String school;
	private String grade;
	
	public Registration()
	{
		//Enter Data
		
		
		//Student Data
		JButton bRegisterStudent = new JButton("Register Student");
		bRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setStudentData();
			}
		});
		bRegisterStudent.setBounds(141, 221, 127, 46);
		bRegisterStudent.setFont(new Font("Dialog", Font.PLAIN, 14));
		getContentPane().add(bRegisterStudent);
		
		//Text Fields
		tName = new JTextField();
		tName.setBounds(40, 80, 130, 26);
		getContentPane().add(tName);
		tName.setColumns(10);
		
		tAge = new JTextField();
		tAge.setBounds(40, 140, 130, 26);
		getContentPane().add(tAge);
		tAge.setColumns(10);
		
		tSchool = new JTextField();
		tSchool.setBounds(230, 80, 130, 26);
		getContentPane().add(tSchool);
		tSchool.setColumns(10);
		
		tGrade = new JTextField();
		tGrade.setBounds(230, 140, 130, 26);
		getContentPane().add(tGrade);
		tGrade.setColumns(10);
		
		
		//Labels
		JLabel lName = new JLabel("Name");
		lName.setBounds(40, 60, 61, 16);
		getContentPane().add(lName);
		
		JLabel lAge = new JLabel("Age");
		lAge.setBounds(40, 120, 61, 16);
		getContentPane().add(lAge);
		
		JLabel lSchool = new JLabel("School");
		lSchool.setBounds(230, 60, 61, 16);
		getContentPane().add(lSchool);
		
		JLabel lGrade = new JLabel("Grade");
		lGrade.setBounds(230, 120, 61, 16);
		getContentPane().add(lGrade);
	}
	
	private void setStudentData()
	{
		if(!tName.getText().equals("") && !tAge.getText().equals("") && !tSchool.getText().equals("") && !tGrade.getText().equals("")) 
		{
			name = tName.getText();
			school = tSchool.getText();
			age = tAge.getText();
			grade = tGrade.getText();
			
			Student.registerStudent(name, age, school, grade);
		}
	}
	
	public String name()
	{
		return "Register New Student";
	}
}
