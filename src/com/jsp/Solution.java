package com.jsp;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		System.out.println("WELCOME to student DATABASE");
		System.out.println("---------------------");
		StudentManagementSystem sms=new StudentManagementSystemImpl();
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter the choice\n1: add Students\n2:Remove Student\n3:Remove allStudent\n4:Display Students");
			System.out.println("5:Display All Students\n6:Update Student\n7:Count Student\n8:Sort Students");
			System.out.println("9:find Student with HighestMarks\n10:find Student with Lowest Marks");
			System.out.println("11:Exit");
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.removeStudent();
				break;
			case 3:
				sms.removeallStudents();
				break;
			case 4:
				sms.displayStudent();
				break;
			case 5:
				sms.displayAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudents();
				break;
			case 9:
				sms.findStudentwithHighestMarks();
				break;
			case 10:
				sms.findStudentwithLowestMarks();
				break;
				
			default:
				System.out.println("Invailid choice");
			}
		}


	}

}
