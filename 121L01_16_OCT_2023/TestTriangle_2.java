// What is an Equilateral triangle?
// - It is a triangle with 3 sides; and all the 3 sides are the same
// - It may be filled in color
//
// what is an Isosceles triangle?
// - It is a triangle with 3 sides and any of the 2 sides are the same
// - It may be filled in colour
//
// What can we do to a triangle?
// - we can compute its area and its perimeter
//
// Ideally we should have a method to display other object information
// File name: TestTriangle_2.java

class Equilateral extends Object
{
	private int a;
	private boolean isFilled;
	
	// default constructor
	public Equilateral ()
	{
		// implictly call to superclass default constructor
		a = 1;
	}
	
	// other constructor
	public Equilateral (boolean isFilled, int a)
	{
		// implictly call to superclass default constructor
		this.isFilled = isFilled;
		this.a = a;
	}
	
	// copy constructor
	public Equilateral (Equilateral e)
	{
		this(e.isFilled, e.a);
	}
	
	// accessor method
	public boolean isFilled ()
	{
		return isFilled;
	}
	
	public int getA ()
	{
		return a;
	}
	
	// mutator method
	public void setInfo (boolean isFilled, int a)
	{
		this.isFilled = isFilled;
		this.a = a;
	}
	
	// area method
	public double area ()
	{
		double s = (a + a + a) / 2.0;
		
		return Math.sqrt (s * (s - a) * (s - a) * (s - a));
	}
	
	// perimeter method
	public int perimeter ()
	{
		return a + a + a;
	}
	
	
	// toString method ()
	@Override
	public String toString ()
	{
		return String.format ("Equilateral (%b, %d)", isFilled, a);
	}

}

// implictly class Isosceles extends Object
class Isosceles
{
	private int a;
	private int b;
	private boolean isFilled;
	
	public Isosceles ()
	{
		// implictly call to superclass default constructor
		a = 1;
	}
	
	public Isosceles (boolean isFilled, int a)
	{
		this.isFilled = isFilled;
		this.a = a;
	}
	
	public Isosceles (boolean isFilled, int a, int b)
	{
		this.isFilled = isFilled;
		this.a = a;
		this.b = b;
	}
	
	public Isosceles (Isosceles i)
	{
		this (i.isFilled, i.a, i.b);
	}
	
	public int getA ()
	{
		return a;
	}
	
	public int getB ()
	{
		return b;
	}
	
	public boolean getIsFilled ()
	{
		return isFilled;
	}
	
	public void setInfo (boolean isFilled, int a)
	{
		this.isFilled = isFilled;
		this.a = a;
	}
	
	public void setInfo (boolean isFilled, int a, int b)
	{
		this.isFilled = isFilled;
		this.a = a;
		this.b = b;
	}
	
	public double area ()
	{
		if (b == 0)
		{
			double s = (a + a + a) / 2.0;
			return Math.sqrt (s * (s - a) * (s - a) * (s - a));
		}
		else 
		{
			double s = (a + a + b) / 2.0;
			return Math.sqrt (s * (s - a) * (s - a) * (s - b));
		}
	}
	
	public int perimeter ()
	{
		if (b == 0)
		{
			return (a + a + a);
		}
		else
		{
			return (a + a + b);
		}
	}
	
	@Override
	public String toString ()
	{
		if (b == 0)
		{
			return String.format ("Isosceles (Equilateral (%b, %d))", isFilled, a);
		}
		else
		{
			return String.format ("Isosceles (%b, %d, %d)", isFilled, a, b);
		}
	}
}
	
class TestTriangle_2
{
	private static void displayInfo (String title, Equilateral e)
	{
		System.out.printf ("%s = %s%n", title, e);
		System.out.printf ("Its area is %.4f%n", e.area ());
		System.out.printf ("Its perimeter is %d%n", e.perimeter ());
		System.out.println ("-------------------------------------------------");
	}
	
	private static void displayInfo (String title, Isosceles e)
	{
		System.out.printf ("%s = %s%n", title, e);
		System.out.printf ("Its area is %.4f%n", e.area ());
		System.out.printf ("Its perimeter is %d%n", e.perimeter ());
		System.out.println ("-------------------------------------------------");
	}
	
	public static void main (String [ ] args)
	{
			Equilateral e0 = new Equilateral ();
			Equilateral e1 = new Equilateral (true, 5);
			Equilateral e2 = new Equilateral (e1);
			
			displayInfo ("e0", e0);
			displayInfo ("e1", e1);
			displayInfo ("e2", e2);
	
		Isosceles i0 = new Isosceles ();
		Isosceles i1 = new Isosceles (true, 8);
		Isosceles i2 = new Isosceles (false, 6, 7);
		Isosceles i3 = new Isosceles (i2);
		
		displayInfo ("i0", i0);
		displayInfo ("i1", i1);
		displayInfo ("i2", i2);
		displayInfo ("i3", i3);
		
	}
}