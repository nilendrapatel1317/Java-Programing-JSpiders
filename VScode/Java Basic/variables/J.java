class J 
{
	static int i ;
	public static void main(String[] args) 
	{
		System.out.println(i); // refers i value from static variable
		int i = 10;
		System.out.println(i); // refers i value from local variable
		System.out.println(J.i); // refers i value from static variable
	}
}
