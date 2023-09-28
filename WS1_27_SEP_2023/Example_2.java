// What is a Java program?
//
// How to read in the information?
//
// File name: Example_2.java

import java.util.Scanner;

class Example_2
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
	
		// Display the information
		System.out.println ();
		System.out.println ("Student information");
		System.out.println ("\tName: " + name);
		System.out.println ("\tGender: " + gender);
		System.out.println ("\tAge: " + age);
		System.out.println ("\tSubject 1: " + subject1 + ", mark: " + mark1);
		System.out.println ("\tSubject 2: " + subject2 + ", mark: " + mark2);
	}
}