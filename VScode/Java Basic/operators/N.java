class N 
{
	public static void main(String[] args) 
	{
		int a = 0;
		int b = 0;
		b = a++ + ++a + a++;
		System.out.println(a);
		System.out.println(b);
	}
}
