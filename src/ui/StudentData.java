package ui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import students.Student;

import javax.swing.event.ListSelectionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentData extends TemplateUI
{
	private static final long serialVersionUID = 1L;
	private JTextField tName;
	private JTextField tAge;
	private JTextField tSchool;
	private JTextField tGrade;
		
	public StudentData()
	{
		getContentPane().setLayout(null);
		
		
		DefaultListModel<String> list = new DefaultListModel<String>();
		for(int i = 0; i < Student.students.size(); i++)
		{
			list.addElement(Student.students.get(i).toString());
		}
		
		JList<String> studentList = new JList<String>(list);
		studentList.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		studentList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) 
			{
				tName.setText(Student.students.get(e.getFirstIndex()).getName());
				tAge.setText(Student.students.get(e.getFirstIndex()).getAge());
				tSchool.setText(Student.students.get(e.getFirstIndex()).getSchool());
				tGrade.setText(Student.students.get(e.getFirstIndex()).getGrade());
			}
		});
		studentList.setVisibleRowCount(Student.students.size());		
		studentList.setBounds(61, 64, 157, 235);
		getContentPane().add(studentList);
		
		JLabel lName = new JLabel("Name:");
		lName.setBounds(243, 60, 61, 16);
		getContentPane().add(lName);
		
		tName = new JTextField();
		tName.setBounds(243, 80, 130, 26);
		getContentPane().add(tName);
		tName.setColumns(10);
		
		JLabel lAge = new JLabel("Age:");
		lAge.setBounds(243, 120, 61, 16);
		getContentPane().add(lAge);
		
		tAge = new JTextField();
		tAge.setBounds(243, 140, 130, 26);
		getContentPane().add(tAge);
		tAge.setColumns(10);
		
		JLabel lSchool = new JLabel("School:");
		lSchool.setBounds(243, 180, 61, 16);
		getContentPane().add(lSchool);
		
		tSchool = new JTextField();
		tSchool.setBounds(243, 200, 130, 26);
		getContentPane().add(tSchool);
		tSchool.setColumns(10);
		
		JLabel lGrade = new JLabel("Grade:");
		lGrade.setBounds(243, 240, 61, 16);
		getContentPane().add(lGrade);
		
		tGrade = new JTextField();
		tGrade.setBounds(243, 260, 130, 26);
		getContentPane().add(tGrade);
		tGrade.setColumns(10);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Controller.sortStudents();
			}
		});
		btnSort.setBounds(81, 33, 117, 29);
		getContentPane().add(btnSort);
	}
	
	public void reload()
	{
		
	}
	
	public String name()
	{
		return "Student Database";
	}
}
