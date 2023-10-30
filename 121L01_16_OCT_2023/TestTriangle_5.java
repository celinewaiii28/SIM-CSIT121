// What is an Equilateral triangle?
// - It is a triangle with 3 sides; and all the 3 sides are the same
// - It may be filled in color
//
// what is an Isosceles triangle?
// - It is a triangle with 3 sides and any of the 2 sides are the same
// - It may be filled in colour
//
// What is a triangle?
// - A triangle has 3 sides
// - It may be filled in color
//
//
// This implies that Isosceles triangle class is a subclass of Equilateral triangle class
//
// File name: TestTriangle_5.java (better version)
//
// Let Java enjoy a little of polymorphism (we will see in more detail in next topic)

import java.util.ArrayList;

class Equilateral extends Object
{
	protected int a;
	protected boolean isFilled;
	
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

// A subclass of Equilateral triangle class
class Isosceles extends Equilateral
{
	protected int b;
	
	public Isosceles ()
	{
		// implicitly calls the super default constructor
		// to initialize a and isFilled
	}
	
	public Isosceles (boolean isFilled, int a)
	{
		super (isFilled, a);
	}
	
	public Isosceles (boolean isFilled, int a, int b)
	{
		super (isFilled, a);
		this.b = b;
	}
	
	public Isosceles (Isosceles i)
	{
		this (i.isFilled, i.a, i.b);
	}
	
	
	public int getB ()
	{
		return b;
	}
	
	public void setInfo (boolean isFilled, int a)
	{
		super.setInfo (isFilled, a);
	}
	
	public void setInfo (boolean isFilled, int a, int b)
	{
		setInfo (isFilled, a);
		this.b = b;
	}
	
	@Override
	public double area ()
	{
		if (b == 0)
		{
			return super.area ();
		}
		else 
		{
			double s = (a + a + b) / 2.0;
			return Math.sqrt (s * (s - a) * (s - a) * (s - b));
		}
	}
	
	@Override
	public int perimeter ()
	{
		if (b == 0)
		{
			return super.perimeter ();
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
			return String.format ("Isosceles (%s)", super.toString ());
		}
		else
		{
			return String.format ("Isosceles (%b, %d, %d)", isFilled, a, b);
		}
	}
}

class Triangle extends Isosceles
{
	private int c;
	
	public Triangle ()
	{
		super ();
	}
	
	public Triangle (boolean isFilled, int a)
	{
		super (isFilled, a);
	}
	
	public Triangle (boolean isFilled, int a, int b)
	{
		super (isFilled, a, b);
	}
	
	public Triangle (boolean isFilled, int a, int b, int c)
	{
		super (isFilled, a, b);
		this.c = c;
	}
	
	public Triangle (Triangle t)
	{
		this (t.isFilled, t.a, t.b, t.c);
	}
	
	public int getC ()
	{
		return c;
	}
	
	public void setInfo (boolean inFilled, int a, int b, int c)
	{
		super.setInfo (inFilled, a, b);
		this.b = b;
	}
	
	@Override
	public double area ()
	{
		if (a * b * c == 0)
			return super.area ();
		else
		{
			double s = (a + b + c) / 2.0;
			return Math.sqrt (s * (s - a) * (s - b) * (s - c));
		}
	}
	
	@Override
	public int perimeter ()
	{
		if (a * b * c == 0)
			return super.perimeter ();
		else
			return a + b + c;
	}
	
	@Override
	public String toString ()
	{
		if (a * b * c == 0)
			return String.format ("Triangle (%s)", super.toString ());
		else
			return String.format ("Triangle (%b, %d, %d, %d)", isFilled, a, b, c);
	}
}
	
class TestTriangle_5
{
	private static void displayInfo ( Equilateral e)
	{
		System.out.printf ("Triangle is %s%n", e);
		System.out.printf ("Its area is %.4f%n", e.area ());
		System.out.printf ("Its perimeter is %d%n", e.perimeter ());
		System.out.println ("-------------------------------------------------");
	}

	private static void constructAList (ArrayList <Equilateral> alist)
	{
		Equilateral e0 = new Equilateral ();
		Equilateral e1 = new Equilateral (true, 5);
		Equilateral e2 = new Equilateral (e1);
		
		Isosceles i0 = new Isosceles ();
		Isosceles i1 = new Isosceles (true, 8);
		Isosceles i2 = new Isosceles (false, 6, 7);
		Isosceles i3 = new Isosceles (i2);
		
		Triangle t0 = new Triangle ();
		Triangle t1 = new Triangle (true, 7);
		Triangle t2 = new Triangle (false, 5, 6);
		Triangle t3 = new Triangle (true, 8, 9, 10);
		Triangle t4 = new Triangle (t3);
		
		alist.add (e0);
		alist.add (e1);
		alist.add (e2);
		alist.add (i0);
		alist.add (i1);
		alist.add (i2);
		alist.add (i3);
		alist.add (t0);
		alist.add (t1);
		alist.add (t2);
		alist.add (t3);
		alist.add (t4);
	}
	
	private static void displayAList (ArrayList <Equilateral> alist)
	{
		for (Equilateral e : alist)
		{
			displayInfo (e);
		}
	}
	
	public static void main (String [ ] args)
	{
			ArrayList <Equilateral> alist = new ArrayList <Equilateral> ();
			
			constructAList (alist);
			displayAList (alist);
	}
}