package com.customsorting;

import java.util.Comparator;

import com.jsp.Student;

public class SortStudentByAge implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
	
		return o1.getAge()-o2.getAge();
	}

}

//o1 ->object to be inserted & y -> already existing object
