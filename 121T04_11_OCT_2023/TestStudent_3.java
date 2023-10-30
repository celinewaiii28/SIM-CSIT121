// A case study
//
// What is a student?
// - A student has an id
// - A student takes 0, 1, 2 subjects, may be a project

// Add in an enum class
//
// File name: TestStudent_3.java

import java.util.ArrayList;

enum UOWGrade
{
	HD ("High Distinction", 85, 100),
	  D ("Distinction", 75, 84),
	  C ("Credit", 65, 74),
	  P ("Pass", 50, 64),
	  F ("Fail", 0, 49);
	  
	  // Some private instance variables
	  private final String title;
	  private final int lowerRange;
	  private final int upperRange;
	  
	  // constructior ==> NO public
	  UOWGrade (String title, int lowerRange, int upperRange)
	  {
		  this.title = title;
		  this.lowerRange = lowerRange;
		  this.upperRange = upperRange;
	  }
	  
	  // Accessor methods
	  public String getTitle ()
	  {
		  return title;
	  }
	  
	  public int getLowerRange ()
	  {
		  return lowerRange;
	  }
	  
	  public int getUpperRange ()
	  {
		  return lowerRange;
	  }
}
	  

class Subject
{
	private String code;
	private int mark;
	private UOWGrade g;
	
	// default constructor
	public Subject ()
	{
	
	}
	
	// Other constructor
	public Subject (String code, int mark)
	{
		/*
		this.code = code;
		this.mark = mark;
		*/
		
		setInfo (code, mark);
	}
	
	// Copy constructor
	public Subject (Subject s)
	{
		this (s.code, s.mark);
	}
	
	// Accessor methods
	public String getCode ()
	{
		return code;
	}
	
	public int getMark ()
	{
		return mark;
	}
	
	// Mutator method
	public void setInfo (String code, int mark)
	{
		this.code = code;
		this.mark = mark;
		processGrade ();
	}
	
	public void processGrade ()
	{
		if (mark >= UOWGrade.HD.getLowerRange())
			g = UOWGrade.HD;
		else if (mark >= UOWGrade.D.getLowerRange())
			g = UOWGrade.D;
		else if (mark >= UOWGrade.C.getLowerRange())
			g = UOWGrade.C;
		else if (mark >= UOWGrade.P.getLowerRange())
			g = UOWGrade.P;
		else 
			g = UOWGrade.F;
	}
	
	// toString method
	public String toString ()
	{
		return String.format ("Subject code: %s, Mark: %d, Grade: %s", code, mark, g);
	}
}

class Student
{
	private static int NO = 2023000;
	
	private final int id;
	private Subject s1;
	private Subject s2;
	private boolean project;
	
	public Student ()
	{
		++NO;
		id = NO;
	}
	
	public Student (boolean project)
	{
		this ();
		this.project = project;
	}
	
	public Student (boolean project, Subject s1)
	{
		this ();
		this.project = project;
		this.s1 = new Subject (s1);
	}
	
	public Student (boolean project, Subject s1, Subject s2)
	{
		this ();
		this.project = project;
		this.s1= new Subject (s1);
		this.s2 = new Subject (s2);
	}
	
	public Student (Student s)
	{
		this ();
		//this (s.project, s.s1, s.s2);
		
		this.project = s.project;
		this.s1 = new Subject (s.s1);
		this.s2 = new Subject (s.s2);
	}
	
	// Accessor method
	public int getID ()
	{
		return id;
	}
	
	public Subject getSubject1 ()
	{
		return s1;
	}
	
	public Subject getSubject2 ()
	{
		return s2;
	}
	
	public boolean getProject ()
	{
		return project;
	}
	
	// Mutator method
	public void setInfo (boolean project)
	{
		this.project = project;
	}
	
	public void setInfo (Subject s1)
	{
		this.s1 =  new Subject (s1);
	}
	
	public void setInfo (Subject s1, Subject s2)
	{
		setInfo (s1);
		this.s2 = new Subject (s2);
	}
	
	/* compiler nakes noise as id is final
		public void setID (int id)
		{
			this.id = id;
		}
	*/
	
	public String toString ()
	{
		if (s1 == null && s2 == null)
			return String.format ("Student id: %d%n" + "Project: %b", id, project);
		else if (s2 == null)
			return String.format ("Student id: %d%n" + "Project: %b%n" + "%s",
												id, project, s1);
		else
			return String.format ("Student id: %d%n" + "Project: %b%n" + "%s%n" + "%s",
												id, project, s1, s2);
	}
		
}
	

class TestStudent_3
{
	private static int getMark ()
	{
		return (int) (Math.random () * 101);
	}
	
	private static void displayGradeInfo ()
	{
		System.out.println ("UOW Grade info");
		
		System.out.printf ("\n%-10s" + "%-20s" + "%-10s" + "%-10s%n",
		                                   "Grade", "Detail", "Minimum", "Maximum");
										   
		for (UOWGrade g : UOWGrade.values ())
		{
			System.out.printf ("%-10s" + "%-20s" + "%-10d" + "%-10d%n",
												g, g.getTitle (), g.getLowerRange (), g.getUpperRange ());
		}
		
		System.out.println ();
	}
	
	private static void constructAList (ArrayList <Student> alist)
	{
		Student s0 = new Student ();
		Student s1 = new Student (true);
		Student s2 = new Student (false, new Subject ("CSIT121", getMark ()));
		Student s3 = new Student (true, new Subject ("CSIT121", getMark ()),
																new Subject ("CSIT121", getMark ()));
		Student s4 = new Student (s3);
		s2.setInfo (true);
		
		alist.add (s0);
		alist.add (s1);
		alist.add (s2);
		alist.add (s3);
		alist.add (s4);
	}
	
	private static void displayAList (ArrayList<Student> alist)
	{
		for (Student s : alist)
		{
			System.out.println (s);
			
			System.out.println ("---------------------------------------------");
		}
		
	}
		
		
	
	public static void main (String [ ] args)
	{
		ArrayList <Student> alist = new ArrayList <Student> ();
		
		displayGradeInfo ();
		
		constructAList (alist);
		displayAList (alist);
	}
}
