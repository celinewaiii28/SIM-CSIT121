// A two D array of double data type
//
// File name: TwoD_1.java

class TwoD_1
{
	public static void main (String [ ] arg)
	{
		double [ ] [ ] a = new double [8] [6];
		
		// display the two D array
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a [i].length; j++)
				System.out.printf ("%-10.4f", a [i][j]);
			System.out.println ();
		}
	}
}