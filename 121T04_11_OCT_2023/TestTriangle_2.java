// What is an equilateral triangle
//  - All the three sides are the same
//  - And the triange may be filled in color
//
// What is an isosceles triangle
// - Any of the two sides are the same.
// - and, the triangle may be filled in color
// 
// What can we do to the triangle?
//  - We can compute its area and its perimeter
//
// File name: TestTriangle_2.java
// It is always good to have a display method in the main class

class Equilateral extends Object
{
	private int a;
	private boolean isFilled;
	
	//Default constructor 
	public Equilateral()
	{
		//implicit call to superclass default constructor
		a = 1;
	}
	
	//other constructor
	public Equilateral(int a, boolean isFilled)
	{
		//implicit call to superclass default constructor
		this.a = a;
		this.isFilled = isFilled;
	}
	
	//copy constructor
	public Equilateral(Equilateral e)
	{
		this(e.a, e.isFilled);
	}
	
	//accesor method
	public int getA()
	{
		return a;
	}

	public boolean getIsFilled()
	{
		return isFilled;
	}
	
	//mutator method
	public void setInfo(int a, boolean isFilled)
	{
		this.a = a;
		this.isFilled = isFilled;
	}
	
	//area method
	public double area()
	{
		double s = (a + a + a) / 2.0;
		return Math.sqrt(s*(s-a)*(s-a)*(s-a));
	}
	
	//perimeter method
	public int perimeter ()
	{
		return a + a + a;
	}
	
	@Override
	public String toString()
	{
		return String.format("Equilateral (%d, %b)", a, isFilled);
	}
}

// this class implicitly extends Object
class Isosceles 
{
	private int a;
	private int b;
	private boolean isFilled;
	
	public Isosceles () 
	{
		//implicit call to superclass default constructor
		a = 1;
	}
	
	public Isosceles (int a, boolean isFilled)
	{
		this.a = a;
		this.isFilled = isFilled;
	}
	
	public Isosceles (int a, int b, boolean isFilled)
	{
		this.a = a;
		this.b = b;
		this.isFilled = isFilled;
	}
	
	public Isosceles(Isosceles i)
	{
		this(i.a, i.b, i.isFilled);
	}
	
	// the accesor method
	public int getA()
	{ 
		return a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public boolean getIsFilled()
	{
		return isFilled;
	}
	
	// 2 mutator method
	
	public void setInfo(int a, boolean isFilled)
	{
		this.a = a;
		this.isFilled = isFilled;
	}
	
	public void setInfo(int a, int b, boolean isFilled)
	{
		this.a = a;
		this.b = b;
		this.isFilled = isFilled;
	}
	
	public double area ()
	{
		if (b == 0)
		{
			double s = (a + a + a) / 2.0;
			return Math.sqrt(s*(s-a)*(s-a)*(s-a));
		}
		else
		{
			double s = (a + a + b) / 2.0;
			return Math.sqrt(s*(s-a)*(s-a)*(s-b));
		}
	}
	
	public int perimeter()
	{
		if (b == 0)
			return a + a + a;
		else
			return a + a + b;
	}
	
	@Override
	public String toString()
	{
		String s = "Isosceles";
		
		if (b == 0)
			return String.format("%s (Equilateral (%d, %b))", s, a, isFilled);
		else
			return String.format("%s (%d , %d, %b)", s ,  a , b, isFilled);
	}
}

class TestTriangle_2
{
	private static void displayInfo (String title, Equilateral e)
	{
		System.out.printf("%s = %s%n", title, e);
		System.out.printf("area = %.4f%n", e.area());
		System.out.printf("perimeter = %d%n", e.perimeter());
		System.out.println("===========================");
	}
	
	private static void displayInfo (String title, Isosceles e)
	{
		System.out.printf("%s = %s%n", title, e);
		System.out.printf("area = %.4f%n", e.area());
		System.out.printf("perimeter = %d%n", e.perimeter());
		System.out.println("===========================");
	}
	
	public static void main (String [ ] args)
	{
		Equilateral e0 = new Equilateral ();
		Equilateral e1 = new Equilateral (8, true);
		Equilateral e2 = new Equilateral (e1);
		
		displayInfo ("e0", e0);
		displayInfo ("e1", e1);
		displayInfo ("e2",e2);
		
		Isosceles i0 = new Isosceles();
		Isosceles i1 = new Isosceles(7, true);
		Isosceles i2 = new Isosceles(5, 6, false);
		Isosceles i3 = new Isosceles(i2);
		
		displayInfo ("i0", i0);
		displayInfo ("i1", i1);
		displayInfo ("i2", i2);
		displayInfo ("i3", i3);
		
	}
}
