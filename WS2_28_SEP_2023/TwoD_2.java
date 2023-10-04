// A two D array of double data type
//
// We use initializer list to initialize the 2D array
//
// File name: TwoD_2.java

class TwoD_2
{
	private static double getValue ()
	{
		return Math.random () * 1000.0;
	}
	
	public static void main (String [ ] arg)
	{
		double [ ] [ ] a = { {getValue (), getValue (), getValue (), getValue (), getValue ()},
										{getValue (), getValue (), getValue (), getValue (), getValue ()},
										{getValue (), getValue (), getValue (), getValue (), getValue ()},
										{getValue (), getValue (), getValue (), getValue (), getValue ()},
										{getValue (), getValue (), getValue (), getValue (), getValue ()}};
		
		// display the two D array
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a [i].length; j++)
				System.out.printf ("%-10.4f", a [i][j]);
			System.out.println ();
		}
	}
}