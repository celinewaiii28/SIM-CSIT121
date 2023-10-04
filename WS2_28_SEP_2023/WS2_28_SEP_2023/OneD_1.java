// A one dimensional array of double data type
// - How to declare 
// - How to display
//
// File name: OneD_1.java

class OneD_1
{
	public static void main (String [ ] args)
	{
		// We declare an one D array
		double [ ] a = new double [10];
		
		// display the array
		for (int i = 0; i < a.length; i++)
			System.out.printf ("a [%d] = %.4f%n", i,  a [i]);
	}
}