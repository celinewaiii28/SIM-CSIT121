// What is an equilateral triangle
//  - All the three sides are the same
//  - And the triange may be filled in color
//
// What can we do?
//  - We can compute its area and uts perimeters
//
// File name: TestTriangle_1b.java
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


class TestTriangle_1b
{
	private static void displayInfo (String title, Equilateral e)
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
		
	}
}
