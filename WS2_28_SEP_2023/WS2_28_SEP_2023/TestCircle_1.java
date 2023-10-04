// What is a circle?
// - A circle has a radius
//
// File name: TestCircle_1.java

class Circle
{
	// instance variables
	private double radius;
	
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

class TestCircle_1
{
	private static double getValue ()
	{
		return Math.random () * 100 + 1.0;
	}
	
	public static void main (String [ ] args)
	{
		// Construct an object of Circle class
		Circle c = new Circle ();
		
		// We initialize (update) the radius
		double r = getValue ();
		c.setRadius (r);
		
		// Display the radius 
		System.out.printf ("Radius is %.3f%n", c.getRadius ());
	}
}