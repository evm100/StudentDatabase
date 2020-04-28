package students;

import java.util.ArrayList;

public class Sort 
{
	static ArrayList<Student> list = Student.students;
	
	public static void insertionSort(String type) {	
		
		for (int i=0; i < list.size()-1; i++) {
			
			int k = i+1;
			//saves the current object that will be moved to lowest spot it can go to
			Student swap = list.get(k);
			//compares the strings. if the previous one is lower in value, it will keep moving the current (i) one until it cannot go lower.
				while (k>0 && swap.compareTo(list.get(k-1), type) < 0) {
					//pushes objects in arraylist forward to accomodate for the object moving down
					list.set(k, list.get(k-1));
					k--;
				}
			//
			list.set(k, swap);
		}
		Student.students = list;
	} 

	public static void selectionSort(String type) {
		
		//starts at the beginning of list, covers all list. each time starts one later
		for (int i=0; i < list.size()-1; i++) {
			
			//lowest value object index
			int min = i;
			//looks for lowest value object in search interval.
			for (int k = i+1; k < list.size(); k++) {
				if (list.get(k).compareTo(list.get(min), type) < 0) {
					min = k;
				}
			}
			//swaps the lowest found object w the one on the first slot in the interval
			Student swap = list.get(min);
			list.set(min, list.get(i));
			list.set(i, swap);
		}
		Student.students = list;
	}
}
