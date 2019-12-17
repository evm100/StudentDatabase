package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import students.Registration;
import students.StudentData;

public class MainMenu extends TemplateUI 
{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainMenu()
	{	
		totalButtons = 2;
		buttonHeight = 75;
		//New Student
		JButton bNewStudent = new JButton("New Student");
		bNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Registration registration = new Registration();
				registration.setVisible(true);
				setVisible(false);
			}
		});
		bNewStudent.setBounds(100, spaceButtons(1), 200, buttonHeight);
		bNewStudent.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		getContentPane().add(bNewStudent);
		
		//Student Data
		JButton bStudentData = new JButton("Student Data");
		bStudentData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				StudentData sdata = new StudentData();
				sdata.setVisible(true);
				setVisible(false);
			}
		});
		bStudentData.setBounds(100, spaceButtons(2), 200, buttonHeight);
		bStudentData.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		getContentPane().add(bStudentData);
	}
	
	public void close() 
	{
		System.exit(0);
	}
	
	public String name()
	{
		return "";
	}
}
