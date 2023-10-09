// A class to describe a triangle object
// - A triangle has 3 sides and a type
//
// File name: Triangle_1.java

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
	
	// Display method
	public void displayInfo ()
	{
		System.out.printf ("Triangle (%d, %d, %d, %s)%n", a, b, c, type);
	}
}

public class TestTriangle_1a
{
	public static void main (String [ ] args)
	{
		Triangle t0 = new Triangle ();
		Triangle t1 = new Triangle (2, 2, 2, "Equilateral");
		Triangle t2 = new Triangle (2, 3, 3, "Isosceles");
		Triangle t3 = new Triangle (3, 4, 5, "Scalene");
		Triangle t4 = new Triangle (t3);
		
		t0.displayInfo ();
		t1.displayInfo ();
		t2.displayInfo ();
		t3.displayInfo ();
		t4.displayInfo ();
	}
}
	