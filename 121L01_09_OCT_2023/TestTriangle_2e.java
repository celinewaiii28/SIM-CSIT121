// Multiple constructor
// - Three types of triangles
//    : Equilateral (all sides are the same)
//    : Isosceles (any two sides are the same) 
//    : Scalene (all three sides are different)
//
// Note more use on "this"
//
// File name: TestTriangle_2e.java

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
		
		System.out.printf ("==> %s was created%n", this);			// this means this object
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

class TestTriangle_2e
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
		
	}
}