// Multiple constructor
// - Three types of triangles
//    : Equilateral (all sides are the same)
//    : Isosceles (any two sides are the same) 
//    : Scalene (all three sides are different)
//
// Explore more on this !!!!!
//
// File name: TestTriangle_2b.java

class Triangle 
{
	// instance variables
	int a;
	int b;
	int c;
	
	// default constructor
	public Triangle ()
	{
		this (1);
	}
	
	// This constructor describe Equilateral triangle
	public Triangle (int a)
	{
		this.a = a;
	}
	
	// This constructor describes Isosceles triangle
	public Triangle (int a, int b)
	{
		this (a);
		this.b = b;
	}
	
	// General triangle
	public Triangle (int a, int b, int c)
	{
		this (a, b);
		this.c = c;
	}
	
	// Copy constructor 
	public Triangle (Triangle t)
	{
		this (t.a, t.b, t.c);
	}
	
	public double area ()
	{
		double s;
		
		if (a * b * c != 0)
		{
			s = (a + b + c) / 2.0;
			return Math.sqrt (s * (s - a) * (s - b) * (s - c));
		}
		else if (b == 0)
		{
			s = (a + a + a) / 2.0;
			return Math.sqrt (s * (s - a) * (s - a) * (s - a));
		}
		else
		{
			s = (a + a + b) / 2.0;
			return Math.sqrt (s * (s - a) * (s - a) * (s - b));
		}
	}
	
	public int perimeter ()
	{
		if (a * b * c != 0)
			return a + b + c;
		else if (b == 0)
			return a + a + a;
		else
			return a + a + b;
	}
	
	public String toString ()
	{
		if (a * b * c != 0)
			return String.format ("Scalene (%d, %d, %d)", a, b, c);
		else if (b == 0)
			return String.format ("Equilateral (%d)", a);
		else
			return String.format ("Isoceles (%d, %d)", a, b);
	}
}

class TestTriangle_2b
{
	private static void displayInfo (Triangle t)
	{
		System.out.printf ("Triangle is %s%n", t);
		System.out.printf ("Its area is %.4f%n", t.area ());
		System.out.printf ("Its perimeter is %d%n", t.perimeter ());
		System.out.println ("---------------------------------------");
	}
	
	public static void main (String [ ] args)
	{
		Triangle t0 = new Triangle ();
		Triangle t2 = new Triangle (5);
		Triangle t3 = new Triangle (3, 4);
		Triangle t4 = new Triangle (5, 6, 7);
		Triangle t5 = new Triangle (t4);
		
		displayInfo (t0);
		displayInfo (t2);
		displayInfo (t3);
		displayInfo (t4);
		displayInfo (t5);
		
	}
}