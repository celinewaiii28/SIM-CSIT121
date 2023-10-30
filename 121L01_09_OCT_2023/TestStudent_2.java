// A case study
//
// What is a student?
// - A student has an id
// - A student takes 0, 1, 2 subjects, may be a project
//
// File name: TestStudent_2.java

import java.util.ArrayList;

class Subject
{
	private String code;
	private int mark;
	
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
	}
	
	// toString method
	public String toString ()
	{
		return String.format ("Subject code: %s, Mark: %d", code, mark);
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
		this.s1 = s1;				// I don't like it ...
	}
	
	public Student (boolean project, Subject s1, Subject s2)
	{
		this ();
		this.project = project;
		this.s1= s1;
		this.s2 = s2;
	}
	
	public Student (Student s)
	{
		this (s.project, s.s1, s.s2);
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
		this.s1 = s1;		// I don't like it
	}
	
	public void setInfo (Subject s1, Subject s2)
	{
		setInfo (s1);
		this.s2 = s2;				// I don't like it
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
	

class TestStudent_2
{
	private static int getMark ()
	{
		return (int) (Math.random () * 101);
	}
	
	private static void constructAList (ArrayList <Student> alist)
	{
		Student s0 = new Student ();
		Student s1 = new Student (true);
		Student s2 = new Student (false, new Subject ("CSIT121", getMark ()));
		Student s3 = new Student (true, new Subject ("CSIT121", getMark ()),
																new Subject ("CSIT121", getMark ()));
		Student s4 = new Student (s2);
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
		
		constructAList (alist);
		displayAList (alist);
	}
}
