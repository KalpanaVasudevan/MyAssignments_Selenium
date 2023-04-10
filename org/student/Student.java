package org.student;

import org.department.Department;

public class Student extends Department{
	
	//studentName(),studentDept(),studentId()
	public void studentName()
	{
		System.out.println("Student Name: Kalpana");
		
	}
	public void studentDept()
	{
		System.out.println("Student Departments is: CSE");
	}
	
	public void studentId()
	{
		System.out.println("Student ID: 108302");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s = new Student();
		s.collegeName();
		s.collegeCode();
		s.collegeRank();
		s.deptName();
		s.studentName();
		s.studentDept();
		s.studentId();
	}

}
