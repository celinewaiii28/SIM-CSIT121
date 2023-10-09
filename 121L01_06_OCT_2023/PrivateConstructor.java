// Can constructor private?

class PrivateConstructor
{
	private  int n;

	// private default constructor
	private PrivateConstructor ()
	{
	
	}
	
	// other constructor
	private PrivateConstructor (int n)
	{
		this.n = n;
	}
	
	private int getN ()
	{
		return n;
	}
	
	public static void main (String [ ] args)
	{
		PrivateConstructor pc0 = new PrivateConstructor ();
		PrivateConstructor pc1 = new PrivateConstructor (123);
		
		System.out.printf ("==> value in object pc0 is %d%n", pc0.getN ());
		System.out.printf ("==> value in object pc1 is %d%n", pc1.getN ());
	}
}