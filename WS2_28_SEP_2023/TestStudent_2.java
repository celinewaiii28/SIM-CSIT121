
// Explore the use of ArrayList;
//
// TestStudent_1.java
import java.util.ArrayList;

enum UOWGrade{HD, D, C, P , F}

class Student
{
	private static int NO = 2023000;
	private static final int NoOfAssessment = 8;
	
	private int id;
	private String name;
	private double [] assessment;
	private double exam;
	private int finalMark;
	private UOWGrade g;
	
	//Default constructor
	public Student ()
	{
		NO++;
		this.id = NO;
	}
	
	public Student (String name)
	{
		this ();
		this.name = name;
		this.assessment = new double [NoOfAssessment];
		processAssessment ();
		processExam ();
		processFinalMark ();
		processGrade ();
	}
	
	public Student (Student s)
	{
		this (s.name);
	}
	
	//Accessor Methods
	public int getId ()
	{
		return id;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public double [] getAssessment ()
	{
		return assessment;
	}
	
	public int getFinalMark ()
	{
		return finalMark;
	}
	
	public UOWGrade getGrade ()
	{
		return g;
	}
	
	//Mutator method
	public void setName (String name)
	{
		this.name = name;
	}
	
	//Some private methods
	private double getMark ()
	{
		return Math.random () * 100;
	}
	
	private void processAssessment ()
	{
		for (int i = 0; i < assessment.length; i++)
		{
			assessment[i] = getMark ();
		}
	}
	
	private void processExam ()
	{
		exam = getMark ();
	}
	
	private void processFinalMark ()
	{
		double total = 0.0;
		for (double mark : assessment)
		{
			total += mark;
		}
		
		double average = total / assessment.length;
		
		finalMark = (int) ( (average + exam) / 2.0 + 0.5 );
	}
	
	private void processGrade ()
	{
		if (finalMark >= 85)
			g = UOWGrade.HD;
		else if (finalMark >= 75)
			g = UOWGrade.D;
		else if (finalMark >= 65)
			g = UOWGrade.C;
		else if (finalMark >= 50)
			g = UOWGrade.P;
		else
			g = UOWGrade.F;
	}
		
	public void displayInfo ()
	{
		System.out.printf("%-10d", id);
		System.out.printf("%-10s", name);
		
		for (double mark : assessment)
		{
			System.out.printf("%-6.1f", mark);
		}
		
		System.out.printf("%-6.1f", exam);
		System.out.printf("%-6d", finalMark);
		System.out.printf("%-6s%n", g);
	}
	
	public static int getNoOfAssessment ()
	{
		return NoOfAssessment;
	}
}

class TestStudent_2
{
	private static final String [] nameArray = {"Heng 1", "Heng 2", "Heng 3", "Heng 4",
													"Heng 5", "Heng 6"};
	
	private static void constructList (ArrayList <Student> studentList)
	{
		for (String name : nameArray)
		{
			studentList.add (new Student (name));
		}
	}
	
	private static void displayList (ArrayList <Student> studentList)
	{
		System.out.printf("%-10s", "ID");
		System.out.printf("%-10s", "NAME");
		
		int noOfAssessment = Student.getNoOfAssessment ();
		
		for (int i = 1; i <= noOfAssessment; i++)
		{
			System.out.printf("A%-5d", i);
		}
		
		System.out.printf("%-6s", "EXAM");
		System.out.printf("%-6s", "FINAL");
		System.out.printf("%-6s%n", "GRADE");
		
		for (Student s : studentList)
		{
			s.displayInfo ();
		}
	}
	
	public static void main (String [ ] args)
	{
		ArrayList <Student> studentList = new ArrayList <Student> ();
		
		constructList (studentList);
		
		
		displayList (studentList);
	}
}
