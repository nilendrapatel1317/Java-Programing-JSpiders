import java.util.Scanner;

class A
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int num = scn.nextInt();
		
		int sum = 0;
		
		for(int i=1; i<=num;i++){
			sum+=i;
			System.out.print(i);
			if(i<num) System.out.print(" + ");
		}
		System.out.println(" = " + sum);
	}
}
