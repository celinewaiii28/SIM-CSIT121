// A one dimensional array of double data type
// - How to declare 
// - How to display
//
// File name: OneD_3.java

class OneD_3
{
	private static double getValue ()
	{
		return Math.random () * 1000.0;
	}
	
	public static void main (String [ ] args)
	{
		// We declare an one D array
		double [ ] a = new double [10];
		
		// We construct the one D array
		for (int i = 0; i < a.length; i++)
			a [i] = getValue ();
		
		// display the array
		for (int i = 0; i < a.length; i++)
			System.out.printf ("a [%d] = %.4f%n", i,  a [i]);
	}
}