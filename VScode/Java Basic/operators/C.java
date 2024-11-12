import java.util.Scanner;

class C 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter two numbers:");
		
		int a = scn.nextInt();
		int b = scn.nextInt();
		
		System.out.println("a = " + a + " b = " + b); // a = 10 b = 20 
		System.out.println("Sum of " + a + " and " + b + " = " + (a + b)); // Sum of 10 and 20 = 30
		System.out.println(a + " + " + b + " = " + (a+b)); // 10 + 20 = 30
	}
}
