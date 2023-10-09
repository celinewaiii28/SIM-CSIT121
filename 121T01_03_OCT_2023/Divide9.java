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
// File name: Divide9.java

import java.util.Scanner;

class Divide9
{
	public static void main (String [ ] args)
	{
		//Construct a scanner class object
		Scanner input = new Scanner (System.in);
		
		//Declare variable
		int n;
		
		//Read in an integer
		System.out.print ("Enter a positive integer: ");
		n = input.nextInt();
		
		//To get the sum of digits
		int sum = 0;
		int lastDigit;
		
		while (n > 0)
		{
			lastDigit = n%10;
			sum = sum + lastDigit;
			
			n = n / 10;
		}
		
		//Test divisible by 9
		if (sum % 9 == 0)
			System.out.println ("--> Divisible by 9");
		else
			System.out.println ("--> Not divisible by 9");
	}
}