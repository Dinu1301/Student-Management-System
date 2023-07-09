package com.jsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customsorting.SortStudentByAge;
import com.customsorting.SortStudentById;
import com.customsorting.SortStudentByMarks;
import com.customsorting.SortStudentByName;
import com.jsp.exception.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem
{
	// key ->Student id -> <String> & value -> Student Object -> <Student>
	Map<String,Student> db=new LinkedHashMap<String,Student>();
	Scanner scan=new Scanner(System.in);

	@Override
	public void addStudent() 
	{
		// accepting age
		System.out.println("Enter Student Age");
		int age=scan.nextInt();

		//Accepting name
		System.out.println("Enter the name");
		String name=scan.next();

		// Accepting age;
		System.out.println("Enter Marks");
		int marks=scan.nextInt();

		// creating a student instance (object)
		Student std=new Student(age,name,marks);

		// Adding entry (Student id & student Object) into the DB (MAP)
		db.put(std.getId(),std);

		System.out.println("Student record Inserted successfully");
		System.out.println("Your student id is "+std.getId());

	}
	@Override
	public void removeStudent() 
	{
		System.out.println("Enter student id ");
		String id=scan.next(); // String id=scan.next.touppercase();
		id=id.toUpperCase(); 

		if(db.containsKey(id))
		{
			db.remove(id);
			System.out.println("Student details deleted successfully");
		}
		else
		{
			try {
				String message="Student with id "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeallStudents() 
	{
		if(!db.isEmpty())
		{
			System.out.println("No of student records : "+db.size());
			db.clear();
			System.out.println("Student records deleted successfully");
		}
		else
		{
			try {
				String message="No student records found to remove";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void displayStudent() 
	{
		// Accepting Student ID-> Jsp101, jsp102, JSP101
		System.out.println("Enter the student id ");
		String id=scan.next(); // String id=scan.next.touppercase();
		id=id.toUpperCase(); // Convertring ID ->touppercase

		// checking if id is present or not (id ->key)
		if(db.containsKey(id)) // db.contains("JSP101")
		{



			System.out.println("Student Record present ");
			Student s=db.get(id); // Getting student objects based on id

			System.out.println("Student details");
			System.out.println("----------------");
			System.out.println("Id :"+s.getId());
			System.out.println("Name :"+s.getName());
			System.out.println("Age :"+s.getAge());
			System.out.println("Marks :"+s.getMarks());

			//			System.out.println(s); -> as toString() is overridden
		}
		else
		{
			try
			{
				String message="Student with id "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}


	@Override
	public void displayAllStudent() 
	{
		// display student records when DB is not empty
		if(!db.isEmpty())
		{
			System.out.println("Student records are as follows");
			System.out.println("-------------------------------");
			Set<String> keys=db.keySet(); // JSP101 JSP102 JSP103 .......
			for(String key:keys)
			{
				// printing student objects as toString is overridden
				System.out.println(db.get(key)); 
			}
		}
		else
		{
			try {
				throw new StudentNotFoundException("No student records to display");		
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent() 
	{
		System.out.println("Enter the student id");
		String id=scan.next(); // String id=scan.next.touppercase();
		id=id.toUpperCase();

		if(db.containsKey(id))
		{
			Student s=db.get(id);
			System.out.println("Enter choice \n1: Update Age\n2:Name\n3:Marks");
			int choice=scan.nextInt();

			switch(choice)
			{
			case 1:
				System.out.println("Enter the Age");
				s.setAge(scan.nextInt());
				System.out.println("Age updated successfully");
				break;

			case 2:
				System.out.println("Enter the name ");
				s.setName(scan.next());
				System.out.println("Name updated Successfully");
				break;
			case 3:
				System.out.println("Enter the Marks");
				s.setMarks(scan.nextInt());
				System.out.println("Marks updated Successfully");
				break;

			default:
				try
				{
					String message="Invalid Choice, Enter Valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			try
			{
				String message="Student with id "+id+" is not found";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudent() 
	{
		System.out.println("Available student Records :"+db.size());
	}

	@Override
	public void sortStudents() 
	{
		// Object of arraylist & reference of list storing student objects
		List<Student> list=new ArrayList();

		// COnverting Map into Set(Keys) using KeySet()
		Set<String> keys=db.keySet(); // JSP101, JSP102, JSP103

		// Traversing keys from set

		for(String key:keys)
		{
			Student s=db.get(key);// Getting value (Student Objects)
			list.add(s); // adding value (Student Object) into List
			// list.add(db.get(key));
		}

		System.out.println("1: Sort student by Age \n2: Sort student by Id\n3:Sort student by Marks\n4:Sort student by Name");
		System.out.println("Enter the choice");
		int choice=scan.nextInt();

		switch(choice)
		{
		case 1:
			Collections.sort(list,new SortStudentByAge());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		case 2:
			Collections.sort(list,new SortStudentById());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		case 3:
			Collections.sort(list,new SortStudentByMarks());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		case 4:
			Collections.sort(list,new SortStudentByName());
			for(Student s:list)
			{
				System.out.println(s);
			}
			break;
		default:
			try
			{
				String message="Invalid Choice, Enter Valid choice";
				throw new InvalidChoiceException(message);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void findStudentwithHighestMarks() 
	{
		List<Student> list=new ArrayList<Student>();
		Set<String> keys=db.keySet();
		for(String key: keys)
		{
			list.add(db.get(key));
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Highest Marks :"+list.get(list.size()-1));

	}

	@Override
	public void findStudentwithLowestMarks() 
	{
		List<Student> list=new ArrayList<Student>();
		Set<String> keys=db.keySet();
		for(String key: keys)
		{
			list.add(db.get(key));
		}
		Collections.sort(list, new SortStudentByMarks());
		System.out.println("Lowest Marks :"+list.get(0));

	}

}
