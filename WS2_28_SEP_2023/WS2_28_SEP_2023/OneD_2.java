// A one dimensional array of double data type
// 
// use initializer list to intialize the array
//
// File name: OneD_2.java

class OneD_2
{
	private static double getValue ()
	{
		return Math.random () * 1000.0;
	}
	
	public static void main (String [ ] args)
	{
		// use initializer list to initialize a D array
		double [ ] a = {getValue (), getValue (), getValue (),
								 getValue (), getValue (), getValue (),
										getValue (), getValue (), getValue ()};
		
		// display the array
		for (int i = 0; i < a.length; i++)
			System.out.printf ("a [%d] = %.4f%n", i,  a [i]);
	}
}