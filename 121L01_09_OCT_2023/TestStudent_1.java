// A case study
//
// What is a subject?
// - A subject has a code
// - A subject has a mark
//
// File name: TestStudent_1.java

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

class TestStudent_1
{
	private static int getMark ()
	{
		return (int) (Math.random () * 101);
	}
	
	public static void main (String [ ] args)
	{
		Subject s1 = new Subject ("CSIT121", getMark ());
		Subject s2 = new Subject ("CSIT128", getMark ());
		
		System.out.println (s1);
		System.out.println (s2);
	}
}
