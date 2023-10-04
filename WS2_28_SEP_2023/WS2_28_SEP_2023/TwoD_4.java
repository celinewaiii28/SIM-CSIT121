// A two D array of double data type
//
// Passing a 2D array to a method, it is passed by reference
//
// File name: TwoD_4.java

class TwoD_4
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
	
	public static void main (String [ ] arg)
	{
		double [ ] [ ] a = new double [8] [6];
		
		// Construct the 2D array
		construct2D (a);
		
		// display the two D array
		display2D (a);
	}
}