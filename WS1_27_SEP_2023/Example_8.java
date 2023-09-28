// What is a Java program?
//
// Explore some user defined methods
//
// The use random method in the Math class
// 
// File name: Example_8.java

import java.util.Scanner;

class Example_8
{
	// This method computes and returns the average of 
	// m1 and m2 (formal parameters)
	private static double getAverage (double m1, double m2)
	{
		double average = (m1 + m2) / 2.0;
		
		return average;
	}
	
	// This method computes and returns the final mark
	// of m1 and m2
	private static int getFinalMark (double m1, double m2)
	{
		double average = getAverage (m1, m2);
		int finalMark = (int) (average + 0.5);
		
		return finalMark;
	}
	
	// This method generates and returns a mark in the range
	// of 0 to 100
	private static double getMark ()
	{
		double m = Math.random ();		// m is between 0 and 1
		m = m * 100.0;							// m is between 0 and 100
		
		return m;
	}
	
	// This method computes and returns the grade of a mark
	private static String getAGrade (int mark)
	{
		if (mark >= 85)
			return "HD";
		else if (mark >= 75)
			return "D";
		else if (mark >= 65)
			return "C";
		else if (mark >= 50)
			return "P";
		else
			return "F";
	}
	
	// Display some messages based on the grade
	private static void displayMessage (String grade)
	{
		// Note the use of falling thru features
		switch (grade)
		{
			case "HD": System.out.println ("\tWell done. You got HD");
								break;
			case "D"    : System.out.println ("\tNot bad. You got a D");
								 break;
			case "C"    : System.out.println ("\tYou got a credit");
			case  "P"   : System.out.println ("\tYou passed the subject");
			default     : System.out.println ("\tHope for better grade in future");
		}
	}
			
	public static void main (String [ ] args)
	{
		// Construct a Scanner class object
		Scanner input = new Scanner (System.in);
		
		// Declare variables
		String name;
		char gender;
		int age;
		String subject1, subject2;
		double mark1, mark2;
		
		// Read in the information
		System.out.print ("Enter a name: ");
		name = input.nextLine ();
		
		System.out.print ("Enter a gender: ");
		gender = input.next ().charAt (0);
		
		System.out.print ("Enter an age: ");
		age = input.nextInt ();
		
		System.out.print ("Enter two subjects: ");
		subject1 = input.next ();
		subject2 = input.next ();
	
		// Generate the marks for the subjects
		mark1 = getMark ();
		mark2 = getMark ();
		
		// Compute some information
		double average = getAverage (mark1, mark2);		// mark1 and mark2 known actual parameters
		int finalMark = getFinalMark (mark1, mark2);
		String grade = getAGrade (finalMark);
	
		// Display the information
		System.out.println ();
		System.out.println ("Student information");
		System.out.printf ("\tName: %s%n",  name);
		System.out.printf ("\tGender: %c%n", gender);
		System.out.printf ("\tAge: %d%n", age);
		System.out.printf ("\tSubject 1: %s, mark: %.2f%n", subject1, mark1);
		System.out.printf ("\tSubject 2: %s, mark: %.2f%n", subject2, mark2);
		System.out.printf ("\tAverage mark: %.2f%n", average);
		System.out.printf ("\tFinal mark: %d%n", finalMark);
		System.out.printf ("\tYour grade: %s%n", grade);
		
		System.out.println ("\nSome words from UOW");
		displayMessage (grade);
	}
}