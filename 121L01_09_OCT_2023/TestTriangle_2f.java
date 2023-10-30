// Multiple constructor
// - Three types of triangles
//    : Equilateral (all sides are the same)
//    : Isosceles (any two sides are the same) 
//    : Scalene (all three sides are different)
//
// Note more use on "this" (next example)
// - compare two triangles and get the bigger one
//
// File name: TestTriangle_2f.java

import java.util.ArrayList;

class Triangle 
{
	// instance variables
	private int a;
	private int b;
	private int c;
	
	// default constructor
	public Triangle ()
	{
		this (1, 0, 0);
	}
	
	// This constructor describe Equilateral triangle
	public Triangle (int a)
	{
		this (a, 0, 0);
	}
	
	// This constructor describes Isosceles triangle
	public Triangle (int a, int b)
	{
		this (a, b, 0);
	}
	
	// General triangle
	public Triangle (int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	// Copy constructor 
	public Triangle (Triangle t)
	{
		this (t.a, t.b, t.c);
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
	
	// mutator methods
	public void setInfo (int a)
	{
		this.a = a;
	}
	
	public void setInfo (int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	
	public void setInfo (int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	private double area ()
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
	
	private int perimeter ()
	{
		if (a * b * c != 0)
			return a + b + c;
		else if (b == 0)
			return a + a + a;
		else
			return a + a + b;
	}
	
	public double getArea ()
	{
		return area ();
	}
	
	public int getPerimeter ()
	{
		return perimeter ();
	}
	
	// This method compares and returns the larger triangle
	public Triangle getLarger (Triangle t)
	{
		if (this.area () > t.area ())
			return this;
		else
			return t;
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

class TestTriangle_2f
{
	private static void displayInfo (Triangle t)
	{
		System.out.printf ("Triangle is %s%n", t);
		System.out.printf ("Its area is %.4f%n", t.getArea ());
		System.out.printf ("Its perimeter is %d%n", t.getPerimeter ());
		System.out.println ("---------------------------------------");
	}
	
	private static void constructAList (ArrayList<Triangle> alist)
	{
		Triangle t0 = new Triangle ();
		Triangle t1 = new Triangle (5);
		Triangle t2 = new Triangle (3, 4);
		Triangle t3 = new Triangle (5, 6, 7);
		Triangle t4 = new Triangle (t3);
		
		alist.add (t0);
		alist.add (t1);
		alist.add (t2);
		alist.add (t3);
		alist.add (t4);
	}
	
	private static void displayAList (ArrayList <Triangle> alist)
	{
		for (Triangle t : alist)
			displayInfo (t);
	}
	
	public static void main (String [ ] args)
	{
		ArrayList <Triangle> alist = new ArrayList <Triangle> ();
		
		constructAList (alist);
		displayAList (alist);
		
		System.out.println ("Compare two triangle objects");
		
		Triangle t1 = alist.get (1);
		Triangle t2 = alist.get (4);
		
		System.out.println ("Compare the following triangles");
		System.out.printf ("t1 = %s%n", t1);
		System.out.printf ("t2 = %s%n", t2);
		
		Triangle larger = t1.getLarger (t2);
		System.out.printf ("\nLarger triangle is %s%n", larger);
		System.out.printf ("Because the area of t1 is %.4f%n", t1.getArea ());
		System.out.printf ("The area of t2 is %.4f%n", t2.getArea ());
		
	}
}