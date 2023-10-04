// What is a circle?
// - A circle has a radius
//
// What is "this"?
//
// File name: TestCircle_3a.java

class Circle
{
	// instance variables
	private double radius;
	
	// default constructor
	public Circle ( )
	{
			radius = 1.0;
	}
	
	// Other constructor
	public Circle (double radius)
	{
		this.radius = radius;
	}
	
	// Accessor method (s)
	public double getRadius ()
	{
		return radius;
	}
	
	// Mutator method
	public void setRadius (double radius)
	{
		this.radius = radius;
	}
	
	// What can we do?
	public double area ()
	{
		return Math.PI * radius * radius;
	}
	
	public double perimeter ()
	{
		return 2.0 * Math.PI * radius;
	}
	
	public void displayInfo ()
	{
		System.out.println ("\nCircle informaton");
		System.out.printf ("\tThe radius is %.3f%n", radius);
		System.out.printf ("\tThe area is %.3f%n", area ());
		System.out.printf ("\tThe perimeter is %.3f%n", perimeter ());
	}
}

class TestCircle_4
{
	private static double getValue ()
	{
		return Math.random () * 100 + 1.0;
	}
	
	public static void main (String [ ] args)
	{
		// Construct a Circle object
		double r = getValue ();
		Circle c = new Circle (r);
		
		// Display the Circle information
		c.displayInfo ();
	}
}