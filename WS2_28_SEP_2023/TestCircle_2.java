// What is a circle?
// - A circle has a radius
//
// All classes have default constructors if you do not have
// other constructors
//
// File name: TestCircle_2.java

class Circle
{
	// instance variables
	private double radius;
	
	// default constructor
	public Circle ( )
	{
			radius = 1.0;
	}
	
	// Accessor method (s)
	public double getRadius ()
	{
		return radius;
	}
	
	// Mutator method
	public void setRadius (double r)
	{
		radius = r;
	}
}

class TestCircle_2
{
	private static double getValue ()
	{
		return Math.random () * 100 + 1.0;
	}
	
	public static void main (String [ ] args)
	{
		// Construct an object of Circle class
		Circle c = new Circle ();
		
		// We display the radius
		System.out.printf ("Radius is %.3f%n", c.getRadius ());
		
		// We initialize (update) the radius
		double r = getValue ();
		c.setRadius (r);
		
		// Display the radius 
		System.out.printf ("After the update to radius, the new radius is %.3f%n", c.getRadius ());
	}
}