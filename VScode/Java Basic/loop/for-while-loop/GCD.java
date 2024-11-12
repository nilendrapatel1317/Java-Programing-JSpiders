import java.util.Scanner;
class GCD 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
	
		System.out.print("Enter first number : ");
		int a = scn.nextInt();
		
		System.out.print("Enter second number :");
		int b = scn.nextInt();
		
		int n = 1 ;
		int i = n;
		
		while (n<=b)
		{
			if(a%n==0 && b%n==0)
			i= n;
			n++;
		}
		System.out.println("GCD of" + a + " and " + b + " is : " + i);
		
		GCD.main(null);
	}
}
