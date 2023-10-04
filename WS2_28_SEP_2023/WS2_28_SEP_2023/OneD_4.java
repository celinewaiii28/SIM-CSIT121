// A one dimensional array of double data type
// 
// Passing an array to a method, it is passed by reference
//
// File name: OneD_4.java

class OneD_4
{
	private static double getValue ()
	{
		return Math.random () * 1000.0;
	}
	
	private static void constructArray (double [ ] a)
	{
			for (int i = 0; i < a.length; i++)
				a [i] = getValue ();
	}
	
	private static void displayArray (double [ ] a)
	{
		for (int i = 0; i < a.length; i++)
			System.out.printf ("a [%d] = %.4f%n", i,  a [i]);
	}
	
	public static void main (String [ ] args)
	{
		// We declare an one D array
		double [ ] a = new double [10];
		
		// We construct the one D array
		constructArray (a);
		
		// display the array
		displayArray (a);
	}
}