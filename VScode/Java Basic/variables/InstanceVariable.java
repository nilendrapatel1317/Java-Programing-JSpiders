class InstanceVariable 
{
	int a = 20;
	public static void main(String[] agrs)
	{
		InstanceVariable.m1();
	}
	
	public static void m1() 
	{
		InstanceVariable obj = new InstanceVariable();
		System.out.println(obj.a);
	}
}
