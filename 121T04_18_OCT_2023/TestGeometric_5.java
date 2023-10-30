// Geometric class
//
// - A geometric object has a color and a field indicating if it is filled in color
//
// - A circle object has a color and a field indicating if it is filled in color
// - A circle has a a (double type)
// - We can compute its area and its perimeter
//
// - A square object has a color and a field indicating if it is filled in color
// - A square has a a (int type)
// - We can compute its area and its perimeter
//
// File name: TestGeometric_5.java
//
// Explore some concepts of abstract class !!!

import java.util.ArrayList;

 abstract class Geometric
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
	
	// Declare 2 Abstract methods
	public abstract double area ();
	public abstract double perimeter ();
}

class Circle extends Geometric
{
	private double a;
	
	public Circle ()
	{
		super ();
		a = 1.0;
	}
	
	public Circle (String color, boolean isFilled, double a)
	{
		super (color, isFilled);
		this.a = a;
	}
	
	public Circle (Circle c)
	{
		this (c.color, c.isFilled, c.a);
	}
	
	// accessor method
	public double getRadius ()
	{
		return a;
	}
	
	// mutator method
	public void setInfo (String color, boolean isFilled, double a)
	{
		super.setInfo (color, isFilled);
		this.a = a;
	}

	// area method
	public double area ()
	{
		return Math.PI * a * a;
	}
	
	// perimeter
	public double perimeter ()
	{
		return 2.0 * Math.PI * a;
	}
	
	@Override
	public String toString ()
	{
		return String.format ("%s%n" + "a = %.4f", super.toString (), a);
	}
}
	
class Square extends Geometric
{
	private int a;
	
	public Square ()
	{
		// implict super statement
		a = 1;
	}
	
	public Square (String color, boolean isFilled, int a)
	{
		super (color, isFilled);
		this.a = a;
	}
	
	public Square (Square sq)
	{
		this (sq.color, sq.isFilled, sq.a);
	}
	
	public int getLength ()
	{
		return a;
	}
	
	public void setInfo (String color, boolean isFilled, int a)
	{
		super.setInfo (color, isFilled);
		this.a = a;
	}
	
	public double area ()
	{
		return 1.0 * a * a;
	}
	
	public double perimeter ()
	{
		return 4.0 * a;
	}
	
	@Override
	public String toString ()
	{
		return String.format ("%s%n" + "a = %d", super.toString (), a);
	}
}



class TestGeometric_6
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
		/*
		abstract class cannot be used to construct object
		Geometric g0 = new Geometric ();
		
		String color = getColor ();
		Geometric g1 = new Geometric (color, getTF (color));
		
		Geometric g2 = new Geometric (g1);
		*/
		
		Circle c0 = new Circle ();
		String color = getColor ();
		Circle c1 = new Circle (color, getTF (color), getValue ());
		Circle c2 = new Circle (c1);
		
		Square sq0 = new Square ();
		color = getColor ();
		Square sq1 = new Square (color, getTF (color), (int) getValue ());
		Square sq2 = new Square (sq1);
		
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