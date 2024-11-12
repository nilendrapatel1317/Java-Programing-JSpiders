class C 
{
	static int i = 10;
	public static void main(String[] args) 
	{
		C.m1();
		C.i = 20;
		C.m1();
	}
	
	public static void m1() 
	{
		System.out.println("m1 starts");
		System.out.println(C.i);
		System.out.println("m1 ends");
	}
}
