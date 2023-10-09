// A positive integer n is divisible by 9 if and only if the sum
// of digits of n is divisible by 9. 

// For example, if n = 12345
//                 ==> 1 + 2 + 3 + 4 + 5 = 15
//                 ==> 15 is not divisible by 9
//                 ==> n is not divisible by 9
//                                                                      
//				if n = 333666
//                 ==> 3 +3 + 3 + 6 + 6 + 6 = 27
//                 ==> 27 is divisible by 9
//                 ==> n is divisible by 9	
// File name: Divide9kkk.java
// What happens if array of object is an instance variable

import java.util.Random;

class DeepCopy
{
	private IntegerInfo [] iiArray;
	
	public DeepCopy () {
		
	}
	
	public DeepCopy (IntegerInfo [] iiArray) {
		this.iiArray = iiArray; // AVOID IF POSSIBLE
	}
	
	public void displayInfo () {
		for (IntegerInfo ii : iiArray) {
			ii.displayInfo ();
		}
	}
}

class IntegerInfo
{
	// Instance variable (all instance variable must be private)
	private int n;
	
	// Explicitly define a default constructor 
	public IntegerInfo ()
	{
		// By default n = 0
	}
	
	// Other constructor
	public IntegerInfo (int n)
	{
		this.n = n;
	}
	
	// Accessor method
	public int getN ()
	{
		return n;
	}
	
	// Mutator method
	public void setInfo (int n)
	{
		this.n = n;
	}
	
	// This method compute and return the sum of digit of n 
	private int getSumOfDigit ()
	{
			int sum = 0;
			int lastDigit;
			
			int nn = n;
			
			while (nn > 0)
			{
				lastDigit = nn%10;
				sum = sum + lastDigit;
				
				nn = nn / 10;
			}
			
			return sum;
	}
	
	// This method test if the sum of digit is divisible by 9
	private boolean testDivisible ()
	{
		int sum = getSumOfDigit ();
		
		if (sum % 9 == 0)
			return true;
		else
			return false;
	}
	
	// To display some info
	public void displayInfo ()
	{
		boolean ok = testDivisible ();
		
		if (ok )
				System.out.printf ("--> %d is divisible by 9%n", n);
			else
				System.out.printf ("--> %d is not divisible by 9%n", n);
			
			System.out.println ("----------------------------------------");
	}
}


class Divide9kkk
{
	private static Random input;
	
	// Generate and return a positive integer
	private static int getAnInteger ()
	{
			int n;
			
			do 
			{
				n = input.nextInt();
			} while (n <= 0);
			
			return n;
	}
	
	private static void constructArray(IntegerInfo [] iiArray) {
		for (int k = 0; k < iiArray.length; k++) {
			int n = getAnInteger ();
			IntegerInfo ii = new IntegerInfo(n);
			iiArray[k] = ii;
		}
	}
	
	private static void displayArray(IntegerInfo [] iiArray) {
		for (IntegerInfo ii : iiArray) {
			ii.displayInfo ();
		}
	}
	
	
	public static void main (String [ ] args)
	{
		
		//Construct a Random class object
		input = new Random ();
		
		// Declare an array of integer info object
		IntegerInfo [] iiArray = new IntegerInfo[6];
		
		// Construct an array
		constructArray(iiArray);
		
		// Construct a DeepCopy class object
		DeepCopy dc = new DeepCopy(iiArray);
		dc.displayInfo ();
		
	}
}