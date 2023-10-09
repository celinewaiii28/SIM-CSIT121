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
// File name: Divide9f.java
// Explore some user defined method to handle for some of the sub tasks
// How to access to public static method defined in another class


import java.util.Random;

class IntegerInfo
{
	// This method compute and return the sum of digit of n (Formal parameter)
	public static int getSumOfDigit (int n)
	{
			int sum = 0;
			int lastDigit;
			
			while (n > 0)
			{
				lastDigit = n%10;
				sum = sum + lastDigit;
				
				n = n / 10;
			}
			
			return sum;
	}
	
	// This method test if the sum of digit is divisible by 9
	public static boolean testDivisible (int sum)
	{
		if (sum % 9 == 0)
			return true;
		else
			return false;
	}
}


class Divide9f
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
	
	
	
	public static void main (String [ ] args)
	{
		//Construct a Random class object
		input = new Random ();
		
		//Declare variable
		int n;
		
		for (int i = 1; i <= 6; i++)
		{
			//Read in an integer
			n = getAnInteger ();
			
			//To get the sum of digits
			int sum = IntegerInfo.getSumOfDigit (n);
			
			//Test divisible by 9
			boolean ok = IntegerInfo.testDivisible (sum);
			if (ok )
				System.out.printf ("--> %d is divisible by 9%n", n);
			else
				System.out.printf ("--> %d is not divisible by 9%n", n);
			
			System.out.println ("----------------------------------------");
		}
	}
}