package ui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import data.DatabaseMethods;
import students.Student;
import util.IO;

import javax.swing.event.ListSelectionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StudentData extends TemplateUI
{
	private static final long serialVersionUID = 1L;
	private JTextField tName;
	private JTextField tAge;
	private JTextField tSchool;
	private JTextField tGrade;
	private JTextField tId;
		
	private int number;
	private JTextField tSearch;
	
	public StudentData()
	{
		getContentPane().setLayout(null);
		
		DatabaseMethods.printStudents(DatabaseMethods.sortByName(Student.students));
		
		DefaultListModel<String> list = new DefaultListModel<String>();
		for (Student student : Student.students)
		{
			list.addElement(student.toString());
		}
		
		JList<String> studentList = new JList<String>(list);
		studentList.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		studentList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) 
			{
				if(e.getValueIsAdjusting())
				{
					IO.print("First Index: " + Integer.toString(e.getFirstIndex()));
					IO.print("Last Index: " + Integer.toString(e.getLastIndex()));
					
					/*
					 * THE FIX TO JLIST:
					 */
					number = (number == e.getLastIndex() ? e.getFirstIndex() : e.getLastIndex());
					/*
					 * 
					 */
					
					Student chosen = Student.students.get(number);
					
					tName.setText(chosen.getName());
					tAge.setText(chosen.getAge());
					tSchool.setText(chosen.getSchool());
					tGrade.setText(chosen.getGrade());
				
					tId.setText(chosen.getId());
				}
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
		
		JLabel lId = new JLabel("Id:");
		lId.setBounds(243, 300, 61, 16);
		getContentPane().add(lId);
		
		tId = new JTextField();
		tId.setBounds(243, 320, 130, 26);
		getContentPane().add(tId);
		tId.setColumns(10);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Student.students = DatabaseMethods.sortByName(Student.students);
				refresh();
			}
		});
		btnSort.setBounds(6, 116, 52, 29);
		getContentPane().add(btnSort);
		
		JButton bRefresh = new JButton("Refresh");
		bRefresh.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		bRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Student.students = DatabaseMethods.toArrayList();
				refresh();
			}
		});
		bRefresh.setIcon(null);
		bRefresh.setBounds(6, 80, 52, 29);
		getContentPane().add(bRefresh);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DatabaseMethods.removeStudent(Integer.valueOf(tId.getText()));
				Student.students = DatabaseMethods.toArrayList();
				refresh();
			}
		});
		btnDelete.setBounds(266, 32, 90, 29);
		getContentPane().add(btnDelete);
		
		tSearch = new JTextField();
		tSearch.setForeground(Color.GRAY);
		tSearch.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		tSearch.setText("Search");
		tSearch.setBounds(88, 33, 130, 26);
		getContentPane().add(tSearch);
		tSearch.setColumns(10);
		
		JButton bSearch = new JButton("Search");
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Student.students = DatabaseMethods.searchName(tSearch.getText());
				refresh();
			}
		});
		bSearch.setBounds(45, 32, 45, 29);
		getContentPane().add(bSearch);
	}
	
	public void refresh()
	{
		StudentData sdata = new StudentData();
		sdata.setVisible(true);
		setVisible(false);
	}
	
	public String name()
	{
		return "Student Database";
	}
}
