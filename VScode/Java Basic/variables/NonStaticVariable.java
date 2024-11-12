class NonStaticVariable 
{
	int i = 10; // Non static Variable
	public static void main(String[] args) 
	{
		NonStaticVariable obj = new NonStaticVariable();
		System.out.println(obj.i);
	}
}

