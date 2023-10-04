// A two D array of double data type
//
// File name: TwoD_3.java

class TwoD_3
{
	private static double getValue ()
	{
		return Math.random () * 1000.0;
	}
	
	public static void main (String [ ] arg)
	{
		double [ ] [ ] a = new double [8] [6];
		
		// Construct the 2D array
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a [i].length; j++)
				a [i][j] = getValue ();
		}
		
		// display the two D array
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a [i].length; j++)
				System.out.printf ("%-10.4f", a [i][j]);
			System.out.println ();
		}
	}
}