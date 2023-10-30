// Introduce private static variable to monitor the number of objects created
//
//
// File name: TestBox_4a.java
//
// 

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

class Box
{
	private static int count = 0;
	
	private Triangle t;
	private double height;
	
	// Default Constructor
	public Box ()
	{
		t = new Triangle ();
		height = 1.0;
		
		++count;
	}
	
	// Other constructor
	public Box (Triangle t, double height)
	{
		this.t = new Triangle (t);
		this.height = height;
		
		count++;
	}
	
	// Copy constructor
	public Box (Box b)
	{
		this (b.t, b.height);
	}
	
	// Accessor methods
	public Triangle getTriangle ()
	{
		return t;
	}
	
	public double getHeight ()
	{
		return height;
	}
	
	// Mutator method
	public void setInfo (Triangle t, double height)
	{
		this.t = new Triangle (t);
		this.height = height;
	}
	
	// private method
	public double volume ()
	{
		return t.getArea () * height;
	}
	
	public double getVolume ()
	{
		return volume ();
	}
	
	// Compare two boxes
	public Box getLarger (Box b)
	{
		if (this.getVolume () > b.getVolume ())
			return this;
		else
			return b;
	}
	
	
	// toString method
	public String toString ()
	{
		return String.format ("Box (%s, %.4f)", t, height);
	}
	
	// public static method
	public static int getCount ()
	{
		return count;
	}
	
}

class TestBox_4a
{
	private static double getValue ()
	{
		return Math.random () * 100 + 1;
	}
	
	private static void constructAList (ArrayList<Box> alist)
	{
		Box b0 = new Box ();
		
		Triangle t1 = new Triangle (5);
		Box b1 = new Box (t1, getValue ());
		
		Triangle t2 = new Triangle (6, 7);
		Box b2 = new Box (t2, getValue ());
		
		Triangle t3 = new Triangle (7, 8, 9);
		Box b3 = new Box (t3, getValue ());
		
		Box b4 = new Box (b3);
		
		alist.add (b0);
		alist.add (b1);
		alist.add (b2);
		alist.add (b3);
		alist.add (b4);
	}
	
	private static void displayAList (ArrayList <Box> alist)
	{
		for (Box b : alist)
		{
			System.out.printf ("The box is %s%n", b);
			System.out.printf ("Its surface area is %.4f%n", b.getTriangle ().getArea ());
			System.out.printf ("Its volume is %.4f%n", b.getVolume ());
			
			System.out.println ("------------------------------------------");
		}
	}
	
	public static void main (String [ ] args)
	{
		ArrayList <Box> alist = new ArrayList <Box> ();
		
		constructAList (alist);
		
		System.out.printf ("No of boxes = %d%n", Box.getCount ());
		
		displayAList (alist);

	}
}