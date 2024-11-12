import java.util.Scanner;
class LCM 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
	
		System.out.print("Enter first number : ");
		int a = scn.nextInt();
		
		System.out.print("Enter second number :");
		int b = scn.nextInt();
		
		int n = a>b ? a : b;
		int i = n;
		
		while (true)
		{
			if(n%a==0 && n%b==0) break;
			n+=i;
		}
		System.out.println("LCM of" + a + " and " + b + " is : " + n);
		
		main(null);
	}
}
