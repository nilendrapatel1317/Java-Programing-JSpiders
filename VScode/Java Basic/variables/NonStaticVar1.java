class NonStaticVar1 
{
	int a = 30; //non static variable
	public static void main(String[] args) 
	{
		
		NonStaticVar1 obj2 = new NonStaticVar1();
		NonStaticVar1.m1();
		System.out.println(obj2.a);
		
	}
	public static void m1()
	{
		NonStaticVar1 obj = new NonStaticVar1();
		System.out.println(obj.a);
		obj.a = 20;
		System.out.println(obj.a);
	}
}
