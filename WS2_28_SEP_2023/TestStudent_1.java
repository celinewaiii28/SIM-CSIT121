// What is a student?
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
// File name: TestStudent_1.java

import java.util.Scanner;

enum Subject {CSIT111, CSIT121, CSIT113, CSIT128}
enum Gender {Male, Female}


class Student
{
	// instance variables
	private String name;
	private Gender gender;
	private int age;
	private Subject subject1;
	private Subject subject2;
    private double mark1;
	private double mark2;
	
	// default constructor
	public Student ()
	{
		// do nothing
	}
	
	// other constructor
	public Student (String name, Gender gender, int age, Subject subject1, Subject subject2,
									double mark1, double mark2)
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.mark1 = mark1;
		this.mark2 = mark2;
	}
	
	// copy constructor
	public Student (Student s)
	{
		this.name = s.name;
		this.gender = s.gender;
		this.age = s.age;
		this.subject1 = s.subject1;
		this.subject2 = s.subject2;
		this.mark1 = s.mark1;
		this.mark2 = s.mark2;
	}
	
	
	// Accessor methods
	public String getName ()
	{
		return name;
	}
	
	public Gender getGender ()
	{
		return gender;
	}
	
	public int getAge ()
	{
		return age;
	}
	
	public Subject getSubject1 ()
	{
		return subject1;
	}
	
	public Subject getSubject2 ()
	{
		return subject2;
	}
	
	public double getMark1 ()
	{
		return mark1;
	}
	
	public double getMark2 ()
	{
		return mark2;
	}
	
	// Mutator methods
	public void setName (String name)
	{
		this.name = name;
	}
	
	public void setGender (Gender g)
	{
		gender = g;
	}
	
	public void setAge (int age)
	{
		this.age = age;
	}
	
	public void setSubjects (Subject s1, Subject s2)
	{
		subject1 = s1;
		subject2 = s2;
	}
	
	public void setMarks (double mark1, double mark2)
	{
		this.mark1 = mark1;
		this.mark2 = mark2;
	}
	

	// This method computes and returns the average of 
	// mark1 and mark2 (formal parameters)
	public  double getAverage ()
	{
		double average = (mark1 + mark2) / 2.0;
		
		return average;
	}
	
	// This method computes and returns the final mark
	// of mark1 and mark2
	public  int getFinalMark ()
	{
		double average = getAverage ();
		int finalMark = (int) (average + 0.5);
		
		return finalMark;
	}
	
	
	
	// This method computes and returns the grade of a mark
	public  String getAGrade (int mark)
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
	public  void displayMessage (String grade)
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
	
	// Display Student info
	public void displayInfo ()
	{
			System.out.println ();
			System.out.println ("Student information");
			System.out.printf ("\tName: %s%n",  name);
			System.out.printf ("\tGender: %s%n", gender);
			System.out.printf ("\tAge: %d%n", age);
			System.out.printf ("\tSubject 1: %s, mark: %.2f%n", subject1, mark1);
			System.out.printf ("\tSubject 2: %s, mark: %.2f%n", subject2, mark2);
			System.out.printf ("\tAverage mark: %.2f%n", getAverage ());
			System.out.printf ("\tFinal mark: %d%n", getFinalMark ());
			
			String grade = getAGrade (getFinalMark ());
			System.out.printf ("\tYour grade: %s%n", grade);
			
			System.out.println ("\nSome words from UOW");
			displayMessage (grade);
	}
}

class TestStudent_1
{
	// This method generates and returns a mark in the range
	// of 0 to 100
	private static double getMark ()
	{
		double m = Math.random ();		// m is between 0 and 1
		m = m * 100.0;							// m is between 0 and 100
		
		return m;
	}
	
	// This method generates and returns a gender
	private static  Gender getGender ()
	{
		int k = (int) (Math.random () * 2);
		
		if (k == 0)
			return Gender.Male;
		else
			return Gender.Female;
	}
	
	// This method generates and returns an age in between 15 to 40
	private static  int getAge ()
	{
		int age = (int) (Math.random () * 26 + 15);
		
		return age;
	}
	
	// This method generates and returns a subject
	private static  Subject getASubject ()
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
	
	public static void main (String [ ] args)
	{
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
			 name = "Heng " + k;
			
			// Get some random info
			gender = getGender ();
			age = getAge ();
			
			// To make sure that subject2 is different from subject1
			subject1 = getASubject ();
			
			do
			{
				subject2 = getASubject ();
			} while (subject1 == subject2);
			
			mark1 = getMark ();
			mark2 = getMark ();
			
			// Construct a student object
			Student s = new Student (name, gender, age, subject1, subject2, mark1, mark2);
			
			// Display student info
			s.displayInfo ();
			
			System.out.println ("----------------------------------------------------------");	
		}
	}
}