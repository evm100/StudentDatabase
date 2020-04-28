package ui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

import data.DatabaseMethods;
import students.Sort;
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
	private int sort = 1;
	
	public StudentData()
	{
		getContentPane().setLayout(null);
		
		//DatabaseMethods.printStudents(DatabaseMethods.sortByName(Student.students));
		
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
		studentList.setBounds(127, 81, 157, 235);
		getContentPane().add(studentList);
		
		JLabel lName = new JLabel("Name:");
		lName.setBounds(294, 60, 61, 16);
		getContentPane().add(lName);
		
		tName = new JTextField();
		tName.setBounds(294, 80, 130, 26);
		getContentPane().add(tName);
		tName.setColumns(10);
		
		JLabel lAge = new JLabel("Age:");
		lAge.setBounds(294, 120, 61, 16);
		getContentPane().add(lAge);
		
		tAge = new JTextField();
		tAge.setBounds(294, 140, 130, 26);
		getContentPane().add(tAge);
		tAge.setColumns(10);
		
		JLabel lSchool = new JLabel("School:");
		lSchool.setBounds(294, 180, 61, 16);
		getContentPane().add(lSchool);
		
		tSchool = new JTextField();
		tSchool.setBounds(294, 200, 130, 26);
		getContentPane().add(tSchool);
		tSchool.setColumns(10);
		
		JLabel lGrade = new JLabel("Grade:");
		lGrade.setBounds(294, 240, 61, 16);
		getContentPane().add(lGrade);
		
		tGrade = new JTextField();
		tGrade.setBounds(294, 260, 130, 26);
		getContentPane().add(tGrade);
		tGrade.setColumns(10);
		
		JLabel lId = new JLabel("Id:");
		lId.setBounds(294, 300, 61, 16);
		getContentPane().add(lId);
		
		tId = new JTextField();
		tId.setBounds(294, 320, 130, 26);
		getContentPane().add(tId);
		tId.setColumns(10);
		
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
		bRefresh.setBounds(6, 80, 111, 29);
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
		btnDelete.setBounds(317, 32, 90, 29);
		getContentPane().add(btnDelete);
		
		
		tSearch = new JTextField();
		tSearch.setForeground(Color.GRAY);
		tSearch.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		tSearch.setText("Search");
		tSearch.setBounds(127, 33, 157, 26);
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
		bSearch.setBounds(10, 32, 107, 29);
		getContentPane().add(bSearch);
		
		/*
		 * Sort by name
		 */
		JButton btnName = new JButton("Name");
		btnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				sort("name");
				refresh();
			}
		});
		btnName.setBounds(20, 160, 89, 23);
		getContentPane().add(btnName);
		
		/*
		 * Sort by age
		 */
		JButton btnAge = new JButton("Age");
		btnAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				sort("age");
				refresh();
			}
		});
		btnAge.setBounds(20, 190, 89, 23);
		getContentPane().add(btnAge);
		
		/*
		 * Sort by Grade
		 */
		JButton btnGrade = new JButton("Grade");
		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				sort("grade");
				refresh();
			}
		});
		btnGrade.setBounds(20, 220, 89, 23);
		getContentPane().add(btnGrade);	
		
		/*
		 * Sort by school
		 */
		JButton btnSchool = new JButton("School");
		btnSchool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				sort("school");
				refresh();
			}
		});
		btnSchool.setBounds(20, 250, 89, 23);
		getContentPane().add(btnSchool);
	}
	
	public void pickSort() {
		if (sort == 1) {
			JButton btnInsertionSort = new JButton("Insertion Sort");
			btnInsertionSort.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			btnInsertionSort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					refresh(2);
				}
			});
			btnInsertionSort.setBounds(6, 116, 111, 29);
			getContentPane().add(btnInsertionSort);
			IO.print("Insertion sort selected");
		} else if (sort == 2) {
			JButton btnSelectionSort = new JButton("Selection Sort");
			btnSelectionSort.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			btnSelectionSort.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					refresh(1);
				}
			});
			btnSelectionSort.setBounds(6, 116, 111, 29);
			getContentPane().add(btnSelectionSort);
			IO.print("Selection sort selected");
		}
	}
	
	public void sort(String type) {
		switch (sort) {
		case 1: Sort.insertionSort(type);
		break;
		case 2: Sort.selectionSort(type);
		} 
	}
	
	public void refresh()
	{
		StudentData sdata = new StudentData();
		sdata.setVisible(true);
		setVisible(false);
		sdata.pickSort();
	}
	
	public void refresh(int sort)
	{
		StudentData sdata = new StudentData();
		sdata.setVisible(true);
		setVisible(false);
		sdata.sort = sort;
		sdata.pickSort();
	}
	
	public String name()
	{
		return "Student Database";
	}
}
