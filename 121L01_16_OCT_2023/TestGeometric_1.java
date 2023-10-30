// Geometric class
//
// - A geometric object has a color and field indicating if it is filled in color
//
// File name: TestGeometric_1.java

import java.util.ArrayList;

class Geometric
{
	private String color;
	private boolean isFilled;
	
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
}

class TestGeometric_1
{
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
	
	private static boolean getTF ()
	{
		int k = (int) (Math.random () * 2);
		
		if (k == 0)
			return true;
		else
			return false;
	}
	
	private static void constructAList (ArrayList <Geometric> alist)
	{
		Geometric g0 = new Geometric ();
		Geometric g1 = new Geometric (getColor (), getTF ());
		Geometric g2 = new Geometric (g1);
		
		alist.add (g0);
		alist.add (g1);
		alist.add (g2);
	}
	
	private static void displayAList (ArrayList <Geometric> alist)
	{
		for (Geometric g : alist)
		{
			System.out.println (g);
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