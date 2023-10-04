// What is a student?
//  - A student has an id (id should be generated inside the student class)
//  - A student has a name
// - A student has gender
// - A student has an age
// - A student takes two subjects
// - A student has marks for the two subjects
//
// What can we do to the student objects?
//  - we can compute student's average, final mark and the grade
//  - we can display student information
//
// Note the construction of an array of student objects
//
// File name: TestStudent_3.java

import java.util.ArrayList;
import java.util.Arrays;

enum UOWGrade {HD, D, C, P, F}

class Student
{
	private static int NO = 2023000;
	private static int NoAssessment = 7;
	
	// instance variables
	private int id;
	private String name;
	private double [ ] assessment;
	private double exam;
	private int finalMark;
	private UOWGrade g;
	
	// default constructor
	public Student ()
	{
		++NO;
		id = NO;
	}
	
	// Other constructor
	public Student (String name)
	{
		++NO;
		id = NO;
		
		this.name = name;
		this.assessment = new double [NoAssessment];
		
		processAsssement ();
		Arrays.sort (assessment);
		
		processExam ();
		processFinalMark ();
		processFinalGrade ();
	}
	
	// Accessor methods
	public int getID () 
	{
		return id;
	}
	
	public double [] getAssessment ()
	{
		return assessment;
	}
	
	public double getExam ()
	{
		return exam;
	}
	
	public int getFinalMark ()
	{
		return finalMark;
	}
	
	public UOWGrade getGrade ()
	{
		return g;
	}
		
	private double getMark ()
	{
		double m = Math.random ();		// m is between 0 and 1
		m = m * 100.0;							// m is between 0 and 100
		
		return m;
	}
	
	private void processAsssement ()
	{
		for (int i = 0; i < assessment.length; i++)
			assessment [i] = getMark ();
	}
	
	private void processExam ()
	{
		exam = getMark ();
	}
	
	private void processFinalMark ()
	{
		double total = 0.0;
		for (double mark : assessment)
			total += mark;
		
		double assessmentAverage = total / assessment.length;
		double average = (assessmentAverage + exam) / 2.0;
		finalMark = (int) (average + 0.5);
	}
	
	private void processFinalGrade ()
	{
		if (finalMark >= 85)
			g = UOWGrade.HD;
		else if (finalMark >= 75)
			g = UOWGrade.D;
		else if (finalMark >= 65)
			g = UOWGrade.C;
		else if (finalMark >= 55)
			g = UOWGrade.P;
		else
			g = UOWGrade.F;
	}
	
	public void displayInfo ()
	{
		System.out.printf ("%-10d", id);
		System.out.printf ("%-10s", name);
	
		for (double mark : assessment)
				System.out.printf ("%-6.1f", mark);
		
		System.out.printf ("%-6.1f", exam);
		System.out.printf ("%-6d", finalMark);
		System.out.printf ("%-6s%n", g);
	}
		
}

class CaseStudy_2
{
	private static String [ ] nameArray = {"Heng 1", "Heng 2", "Heng 3", "Heng 4", "Heng 5"};
	
	private static void constructAList (ArrayList <Student> alist)
	{
		for (String name : nameArray)
		{
			Student s = new Student (name);
			alist.add (s);
		}
	}
	
	private static void displayAList (ArrayList <Student> alist)
	{
		for (Student s : alist)
			s.displayInfo ();
	}
	
	public static void main (String [ ] args)
	{
		ArrayList <Student> alist = new ArrayList <Student> ();
		
		constructAList (alist);
		displayAList (alist);
	}
}