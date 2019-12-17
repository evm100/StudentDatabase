package students;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;

public class Controller 
{
	public static DefaultListModel<String> sortStudents()
	{
		ArrayList<Student> list = Student.students;
		if(list.size() > 1)
		{
			for(int i = 0; i<list.size(); i++)
			{
				if (list.get(i).toString().toLowerCase().charAt(0) > list.get(i+1).toString().toLowerCase().charAt(0))
				{
					Collections.swap(list, i, i+1);
				}
			}
		}
		DefaultListModel<String> sortedList = new DefaultListModel<String>();
		for(int i = 0; i < Student.students.size(); i++)
		{
			sortedList.addElement(list.get(i).toString());
		}
		return sortedList;
	}
}
