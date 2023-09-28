// What is a Java program?
//
// All the examples we saw before this example were "static"
// 
// How to access to non-static members?
//
// File name: Example_11.java

import java.util.Scanner;

enum Subject {CSIT111, CSIT121, CSIT113, CSIT128}
enum Gender {Male, Female}

class Example_11
{
	// This method computes and returns the average of 
	// m1 and m2 (formal parameters)
	private double getAverage (double m1, double m2)
	{
		double average = (m1 + m2) / 2.0;
		
		return average;
	}
	
	// This method computes and returns the final mark
	// of m1 and m2
	private  int getFinalMark (double m1, double m2)
	{
		double average = getAverage (m1, m2);
		int finalMark = (int) (average + 0.5);
		
		return finalMark;
	}
	
	// This method generates and returns a mark in the range
	// of 0 to 100
	private  double getMark ()
	{
		double m = Math.random ();		// m is between 0 and 1
		m = m * 100.0;							// m is between 0 and 100
		
		return m;
	}
	
	// This method generates and returns a gender
	private Gender getGender ()
	{
		int k = (int) (Math.random () * 2);
		
		if (k == 0)
			return Gender.Male;
		else
			return Gender.Female;
	}
	
	// This method generates and returns an age in between 15 to 40
	private  int getAge ()
	{
		int age = (int) (Math.random () * 26 + 15);
		
		return age;
	}
	
	// This method generates and returns a subject
	private Subject getASubject ()
	{
		int k = (int) (Math.random () * 4);		// 0, 1, 2, 3
		
		switch (k)
		{
			case 0: return Subject.CSIT111;
			case 1: return Subject.CSIT121;
			case 2: return Subject.CSIT113;
			default: return Subject.CSIT128;
		}
	}
	
	// This method computes and returns the grade of a mark
	private  String getAGrade (int mark)
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
	private void displayMessage (String grade)
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
		// In order to access to non-static methods defined in the same class
		// we need to construct an object of this class, i.e. Example_11
		Example_11 e11 = new Example_11 ();
		
		// Construct a Scanner class object
		Scanner input = new Scanner (System.in);
		
		// Declare variables
		String name;
		Gender gender;
		int age;
		Subject subject1, subject2;
		double mark1, mark2;
			
		for (int k = 1; k <= 3; ++k)
		{
			// Read in the information
			System.out.print ("Enter a name: ");
			name = input.nextLine ();
			
			// Get some random info
			gender = e11.getGender ();
			age = e11.getAge ();
			
			// To make sure that subject2 is different from subject1
			subject1 = e11.getASubject ();
			
			do
			{
				subject2 = e11.getASubject ();
			} while (subject1 == subject2);
			
			mark1 = e11.getMark ();
			mark2 = e11.getMark ();
			
			// Compute some information
			double average = e11.getAverage (mark1, mark2);		// mark1 and mark2 known actual parameters
			int finalMark = e11.getFinalMark (mark1, mark2);
			String grade = e11.getAGrade (finalMark);
		
			// Display the information
			System.out.println ();
			System.out.println ("Student information");
			System.out.printf ("\tName: %s%n",  name);
			System.out.printf ("\tGender: %s%n", gender);
			System.out.printf ("\tAge: %d%n", age);
			System.out.printf ("\tSubject 1: %s, mark: %.2f%n", subject1, mark1);
			System.out.printf ("\tSubject 2: %s, mark: %.2f%n", subject2, mark2);
			System.out.printf ("\tAverage mark: %.2f%n", average);
			System.out.printf ("\tFinal mark: %d%n", finalMark);
			System.out.printf ("\tYour grade: %s%n", grade);
			
			System.out.println ("\nSome words from UOW");
			e11.displayMessage (grade);
			
			System.out.println ("----------------------------------------------------------");
		}
	}
}