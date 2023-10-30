// Geometric class
//
// - A geometric object has a color and a field indicating if it is filled in color
//
// - A circle object has a color and a field indicating if it is filled in color
// - A circle has a radius (double type)
// - We can compute its area and its perimeter
//
// - A cylinder obeject has a color and a field indicating if it is filled in color
// - A cylinder has a radius (double type) and a height (double type)
// - We can compute its surface area and its volume
//  ==> Cylinder is a subclass of Circle
//
// - A square object has a color and a field indicating if it is filled in color
// - A square has a length (int type)
// - We can compute its area and its perimeter
//
// - A triangle object has a color and a field indicating if it is filled in color
// - A triangle has 3 sides (double type)
// - We can compute its area and its perimeter
//
// File name: TestGeometric_11a.java
//
// Explore the use of interface
//  - one more interface
//
// Circle class is an abstract class
// ==> this version also has compile time error message!!!!
//  ==> abstract class cannot construct objects

import java.util.ArrayList;

interface MyInterface
{
	public final double MYPI = 3.14159256;
	
		// two abstract methods
	public double area ();
	public double perimeter ();
}

interface MyInterface2
{
	public double volume ();
}

abstract class Geometric implements MyInterface
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
}

abstract class Circle extends Geometric implements MyInterface2
{
	protected double a;
	
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
	@Override
	public double area ()
	{
		return MYPI * a * a;
	}
	
	// perimeter
	@Override
	public double perimeter ()
	{
		return 2.0 * MYPI * a;
	}
	
	@Override
	public String toString ()
	{
		return String.format ("%s%n" + "a = %.4f", super.toString (), a);
	}
}

class Cylinder extends Circle
{
	private double height;
	
	public Cylinder ()
	{
		super ();
		height = 1.0;
	}
	
	public Cylinder (String color, boolean isFilled, double radius, double height)
	{
		super (color, isFilled, radius);
		this.height = height;
	}
	
	public Cylinder (Cylinder cy)
	{
		this (cy.color, cy.isFilled, cy.a, cy.height);
	}
	
	public double getHeight ()
	{
		return height;
	}
	
	public void setInfo (String color, boolean isFilled, double radius, double height)
	{
		super.setInfo (color, isFilled, radius);
		this.height = height;
	}
	
	@Override
	public double volume ()
	{
		return super.area () * height;
	}
	
	@Override
	public String toString ()
	{
		return String.format ("%s%n" + "Height = %.4f", super.toString (), height);
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
	
	@Override
	public double area ()
	{
		return 1.0 * a * a;
	}
	
	@Override
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

class Triangle extends Geometric
{
		private double a;
		private double b;
		private double c;
		
		public Triangle ()
		{
			a = 1.0;
		}
		
		public Triangle (String color, boolean isFilled, double a)
		{
			super (color, isFilled);
			this.a = a;
		}
		
		public Triangle (String color, boolean isFilled, double a, double b)
		{
			super (color, isFilled);
			this.a = a;
			this.b = b;
		}
		
		public Triangle (String color, boolean isFilled, double a, double b, double c)
		{
			this(color, isFilled, a, b);
			this.c = c;
		}
		
		public Triangle (Triangle t)
		{
			this(t.color, t.isFilled, t.a, t.b, t.c);
		}
		
		public double getA ()
		{
			return a;
		}
		
		public double getB ()
		{
			return b;
		}
		
		public double getC ()
		{
			return c;
		}
		
		public void setInfo (String color, boolean isFilled, double a)
		{
			super.setInfo(color, isFilled);
			this.a = a;
		}
		
		public void setInfo (String color, boolean isFilled, double a, double b)
		{
			setInfo (color, isFilled, a);
			this.b = b;
		}
		
		public void setInfo (String color, boolean isFilled, double a, double b, double c)
		{
			setInfo (color, isFilled, a, b);
			this.c = c;
		}
		
		@Override
		public double area ()
		{
			if (a * b * c != 0)
			{
				double s = (a + b + c) / 2.0;
				return Math.sqrt(s * (s - a) * (s - b) * (s - c));
			}
			else if (b == 0)
			{
				double s = (a + a + a) / 2.0;
				return Math.sqrt(s * (s - a) * (s - a) * (s - a));
			}
			else
			{
				double s = (a + a + b) / 2.0;
				return Math.sqrt(s * (s - a) * (s - a) * (s - b));
			}
		}			
		
		@Override
		public double perimeter ()
		{
			if (a * b * c != 0)
			{
				return (a + b + c);
			}
			else if (b == 0)
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
			if (a * b * c != 0)
			{
				return String.format ("%s%n" + "a = %.4f%n" + "b = %.4f%n" + "c = %.4f",
													super.toString(), a, b, c);
			}
			else if (b == 0)
			{
				return String.format ("%s%n" + "a = %.4f", super.toString(), a);
			}
			else
			{
				return String.format ("%s%n" + "a = %.4f%n" + "b = %.4f", super.toString(), a, b);
			}
		}
}

class TestGeometric_11a
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
	
	private static void constructAList (ArrayList <MyInterface> alist)
	{
		Circle c0 = new Circle ();
		String color = getColor ();
		Circle c1 = new Circle (color, getTF (color), getValue ());
		Circle c2 = new Circle (c1);
		
		Square sq0 = new Square ();
		color = getColor ();
		Square sq1 = new Square (color, getTF (color), (int) getValue ());
		Square sq2 = new Square (sq1);
		
		Triangle t0 = new Triangle ();
		color = getColor ();
		Triangle t1 = new Triangle (color, getTF (color), getValue ());
		color = getColor ();
		Triangle t2 = new Triangle (color, getTF (color), getValue (), getValue ());
		color = getColor ();
		Triangle t3 = new Triangle (color, getTF (color), getValue (), getValue (), getValue ());
		Triangle t4 = new Triangle (t3);
		
		Cylinder cy0 = new Cylinder ();
		color = getColor ();
		Cylinder cy1= new Cylinder (color, getTF (color), getValue (), getValue ());
		Cylinder cy2 = new Cylinder (cy1);
		
		alist.add (c0);
		alist.add (c1);
		alist.add (c2);
		
		alist.add (sq0);
		alist.add (sq1);
		alist.add (sq2);
		
		alist.add (t0);
		alist.add (t1);
		alist.add (t2);
		alist.add (t3);
		alist.add (t4);
		
		alist.add (cy0);
		alist.add (cy1);
		alist.add (cy2);
	}
	
	private static void displayAList (ArrayList <MyInterface> alist)
	{
		for (MyInterface g : alist)
		{
			System.out.println (g);
			
			System.out.printf ("Its area is %.4f%n", g.area ());
			System.out.printf ("Its perimeter is %.4f%n", g.perimeter ());
			
			if (g instanceof Cylinder)
			{
				Cylinder cy = (Cylinder) (g);			// downcasting
				System.out.printf ("Its volume is %.4f%n", cy.volume ());
			}
			
			System.out.printf ("==> I belong to class %s%n", g.getClass ().getName ());
			System.out.println ("-------------------------------------");
		}
		
	}
	
	public static void main (String [ ] args)
	{
		ArrayList <MyInterface> alist = new ArrayList <MyInterface> ();
		
		constructAList (alist);
		displayAList (alist);
	}
}