// What is a Java program?
//
// How to read in the information?
//
// Explore some formatted outputs
// - The use of the printf methods
//
// File name: Example_4.java

import java.util.Scanner;

class Example_4
{
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
		
		System.out.print ("Enter the marks for the two subjects: ");
		mark1 = input.nextDouble ();
		mark2 = input.nextDouble ();
		
		// Compute some information
		double average = (mark1 + mark2) / 2.0;
		int finalMark = (int)  (average + 0.5);
	
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
	}
}