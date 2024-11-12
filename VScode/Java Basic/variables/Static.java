class Static 
{
	static int i = 10;
	public static void main(String[] args) 
	{
		Static.m1();
		
	}
	
	public static void m1() 
	{
		System.out.println("m1 starts");
		System.out.println(Static.i);
		System.out.println("m1 ends");
	}
}
