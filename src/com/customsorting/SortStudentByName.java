package com.customsorting;

import java.util.Comparator;

import com.jsp.Student;

public class SortStudentByName implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
	
		return o1.getName().compareTo(o2.getName());
	}

}

//o1 ->object to be inserted & y -> already existing object