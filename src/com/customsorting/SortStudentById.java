package com.customsorting;

import java.util.Comparator;

import com.jsp.Student;

public class SortStudentById implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
	
		return o1.getId().compareTo(o2.getId());
	}
}

//o1 ->object to be inserted & y -> already existing object