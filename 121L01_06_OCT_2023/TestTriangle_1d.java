// A class to describe a triangle object
// - A triangle has 3 sides and a type
//
// Construct a String to denote a Triangle
// - Explore the use of String.format to construct a String
//
// Can we display an object using the printf or the println methods?
//
// File name: Triangle_1c.java

class Triangle
{
	// instance variables
	private int a;
	private int b;
	private int c;
	private String type;
	
	// Default constructor
	public Triangle ()
	{
		a = 1;
		b = 1;
		c = 1;
		type = "Equilateral";
	}
	
	// Other constructor
	public Triangle (int a, int b, int c, String type)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.type = type;
	}
	
	// copy constructor
	public Triangle (Triangle t)
	{
		this.a = t.a;
		this.b = t.b;
		this.c = t.c;
		this.type = t.type;
	}
	
	// Accessor methods
	public int getA ()
	{
		return a;
	}
	
	public int getB ()
	{
		return b;
	}
	
	public int getC ()
	{
		return c;
	}
	
	public String getType ()
	{
		return type;
	}
	
	// Mutator methods
	public void setInfo (int a, int b, int c, String type)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.type = type;
	}
	
	// etc methods
	
	// Construct a String to denote a triangle
	public String getString ()
	{
		String s = String.format ("Triangle (%d, %d, %d, %s)", a, b, c, type);
		
		return s;
	}
}

 class TestTriangle_1d
{
	private static void displayInfo (String title, Triangle t)
	{
		System.out.printf ("%s = %s%n", title, t);
	}
	
	public static void main (String [ ] args)
	{
		Triangle t0 = new Triangle ();
		Triangle t1 = new Triangle (2, 2, 2, "Equilateral");
		Triangle t2 = new Triangle (2, 3, 3, "Isosceles");
		Triangle t3 = new Triangle (3, 4, 5, "Scalene");
		Triangle t4 = new Triangle (t3);
		
		displayInfo ("t0", t0);
		displayInfo ("t1", t1);
		displayInfo ("t2", t2);
		displayInfo ("t3", t3);
		displayInfo ("t4", t4);
	}
}
	