// What is a Java program?
//
// In this example, we will explore
// - What are data types?
// - What are variables?
// - How to display some information
//
// File name: Example_1.java

class Example_1
{
	public static void main (String [ ] args)
	{
		// What is a student?
		String name = "Robert Lim";
		char gender = 'M';
		int age = 21;
		String subject1 = "CSIT121";
		String subject2 = "CSIT128";
		double mark1 = 88.5;
		double mark2 = 77.8;
		
		// Display the information
		System.out.println ("Name: " + name);
		System.out.println ("Gender: " + gender);
		System.out.println ("Age: " + age);
		System.out.println ("Subject 1: " + subject1 + ", mark: " + mark1);
		System.out.println ("Subject 2: " + subject2 + ", mark: " + mark2);
	}
}