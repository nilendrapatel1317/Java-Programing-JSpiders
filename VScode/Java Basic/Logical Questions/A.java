//PROGRAM TO PRINT THE TOTAL SUM OF ENTERED NUMBER WITHIN THEIR DIGITS

import java.util.Scanner;
class A 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		int num = scn.nextInt();
		
		int sum=0;
		
		while(num>0){
			sum += num%10;
			num /= 10;
		}
		System.out.println("Sum of all digits : " + sum );
	
		main(null);
	}
}


