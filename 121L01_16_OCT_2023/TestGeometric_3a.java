// Geometric class
//
// - A geometric object has a color and a field indicating if it is filled in color
//
// - A circle object has a color and a field indicating if it is filled in color
// - A circle has a radius (double type)
// - We can compute its area and its perimeter
//
// - A square object has a color and a field indicating if it is filled in color
// - A square has a length (int type)
// - We can compute its area and its perimeter
//
// File name: TestGeometric_3a.java
//
// This version has compile time error message

import java.util.ArrayList;

class Geometric
{
	protected String color;
	protected boolean isFilled;
	
	// default constructor
	public Geometric ()
	{
		color = "White";
		isFilled = false;
	}
	
	// other constructor
	public Geometric (String color, boolean isFilled)
	{
		this.color = color;
		this.isFilled = isFilled;
	}
	
	// copy constructor
	public Geometric (Geometric g)
	{
		this (g.color, g.isFilled);
	}
	
	// accessor methods
	public String getColor ()
	{
		return color;
	}
	
	public boolean getIsFilled ()
	{
		return isFilled;
	}
	
	// mutator method
	public void setInfo (String color, boolean isFilled)
	{
		this.color = color;
		this.isFilled = isFilled;
	}
	
	// toString method
	@Override
	public String toString ()
	{
		return String.format ("Color: %s%n" + "Is filled in color?: %b", color, isFilled);
	}
	
	// two meaningless methods
	public double area ()
	{
		return 0.0;
	}
	
	public double perimeter ()
	{
		return 0.0;
	}
}

class Circle extends Geometric
{
	private double radius;
	
	public Circle ()
	{
		super ();
		radius = 1.0;
	}
	
	public Circle (String color, boolean isFilled, double radius)
	{
		super (color, isFilled);
		this.radius = radius;
	}
	
	public Circle (Circle c)
	{
		this (c.color, c.isFilled, c.radius);
	}
	
	// accessor method
	public double getRadius ()
	{
		return radius;
	}
	
	// mutator method
	public void setInfo (String color, boolean isFilled, double radius)
	{
		super.setInfo (color, isFilled);
		this.radius = radius;
	}

	// area method
	public double area ()
	{
		return Math.PI * radius * radius;
	}
	
	// perimeter
	public double perimeter ()
	{
		return 2.0 * Math.PI * radius;
	}
	
	@Override
	public String toString ()
	{
		return String.format ("%s%n" + "Radius: %.4f", super.toString (), radius);
	}
}
	
class Square extends Geometric
{
	private int length;
	
	public Square ()
	{
		// implict super statement
		length = 1;
	}
	
	public Square (String color, boolean isFilled, int length)
	{
		super (color, isFilled);
		this.length = length;
	}
	
	public Square (Square sq)
	{
		this (sq.color, sq.isFilled, sq.length);
	}
	
	public int getLength ()
	{
		return length;
	}
	
	public void setInfo (String color, boolean isFilled, int length)
	{
		super.setInfo (color, isFilled);
		this.length = length;
	}
	
	public double area ()
	{
		return 1.0 * length * length;
	}
	
	public double perimeter ()
	{
		return 4.0 * length;
	}
	
	@Override
	public String toString ()
	{
		return String.format ("%s%n" + "Length: %d", super.toString (), length);
	}
}

class TestGeometric_3a
{
	private static double getValue ()
	{
		return Math.random () * 100 + 1;
	}
	
	private static String getColor ()
	{
		int k = (int) (Math.random () * 5);
		
		switch (k)
		{
			case 0: return "Red";
			case 1: return "Blue";
			case 2: return "Yellow";
			case 3: return "Green";
			default: return "White";
		}
	}
	
	private static boolean getTF (String color)
	{
		if (color.equals ("White"))
			return false;
		else
			return true;
	}
	
	private static void constructAList (ArrayList <Geometric> alist)
	{
		Geometric g0 = new Geometric ();
		
		String color = getColor ();
		Geometric g1 = new Geometric (color, getTF (color));
		
		Geometric g2 = new Geometric (g1);
		
		Circle c0 = new Circle ();
		color = getColor ();
		Circle c1 = new Circle (color, getTF (color), getValue ());
		Circle c2 = new Circle (c1);
		
		Square sq0 = new Square ();
		color = getColor ();
		Square sq1 = new Square (color, getTF (color), (int) getValue ());
		Square sq2 = new Square (sq1);
		
		alist.add (g0);
		alist.add (g1);
		alist.add (g2);
		alist.add (c0);
		alist.add (c1);
		alist.add (c2);
		alist.add (sq0);
		alist.add (sq1);
		alist.add (sq2);
	}
	
	private static void displayAList (ArrayList <Geometric> alist)
	{
		for (Geometric g : alist)
		{
			System.out.println (g);
			
			// Java will scold me of these two statements
			System.out.printf ("Its area is %.4f%n", g.area ());
			System.out.printf ("Its perimeter is %.4f%n", g.perimeter ());
			System.out.println ("-------------------------------------");
		}
	}
	
	public static void main (String [ ] args)
	{
		ArrayList <Geometric> alist = new ArrayList <Geometric> ();
		
		constructAList (alist);
		displayAList (alist);
	}
}