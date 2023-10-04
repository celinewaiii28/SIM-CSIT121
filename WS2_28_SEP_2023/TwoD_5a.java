// A two D array of double data type
//
// Passing a 2D array to a method, it is passed by reference
//
// To get the largest values stored in a2D array
//
// Explore the use of enhanced for loop
//
// File name: TwoD_5a.java

class TwoD_5a
{
	private static double getValue ()
	{
		return Math.random () * 1000.0;
	}
	
	private static void construct2D (double [ ][ ] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a [i].length; j++)
				a [i][j] = getValue ();
		}
	}
	
	private static void display2D (double [ ][ ] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a [i].length; j++)
				System.out.printf ("%-10.4f", a [i][j]);
			System.out.println ();
		}
	}
	
	private static double getLargest (double [ ] [ ] a)
	{
		double largest = a [0][0];
		
		// for each row in a
		for (double [ ] row : a)
		{
			// for each column in each row
			for (double column : row)
			{
				if (column > largest)
					largest = column;
			}
		}
		
		return largest;
	}
	
	public static void main (String [ ] arg)
	{
		double [ ] [ ] a = new double [8] [6];
		
		// Construct the 2D array
		construct2D (a);
		
		// display the two D array
		display2D (a);
		
		// Display the largest values
		System.out.printf ("\nThe largest value is %.4f%n", getLargest (a)); 
	}
}