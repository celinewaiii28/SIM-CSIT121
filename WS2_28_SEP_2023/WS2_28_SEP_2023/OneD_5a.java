// A one dimensional array of double data type
// 
// Passing an array to a method, it is passed by reference
//
// We wish to get the largest value stored in an array
//
// Note the use of enhanced for loop
//
// File name: OneD_5a.java

class OneD_5a
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
	
	// This method determines and returns the largest values stored in 1D
	//
	// Note the use of enhanced for loop
	private static double getLargest (double [ ] a)
	{
		double largest = a [0];
		
		// for each value inside the array a
		for (double value : a)
		{
			if (value > largest)
				largest = value;
		}
		
		return largest;
	}
	
	public static void main (String [ ] args)
	{
		// We declare an one D array
		double [ ] a = new double [10];
		
		// We construct the one D array
		constructArray (a);
		
		// display the array
		displayArray (a);
		
		// Display the largest element in array
		System.out.printf ("The largest element is %.4f%n", getLargest (a));
	}
}