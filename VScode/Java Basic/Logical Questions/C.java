// PROGRAM TO PRINT TOTAL SUM OF NUMBER IN TWO PART EVEN DIGITS SUM AND ODD DIGITS SUM

import java.util.Scanner;
class C
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		int num = scn.nextInt();
		int eSum = 0;
		int oSum = 0;
		
		
		while(num>0){
			int d = num%10;
			if((d)%2==0){
				eSum += d;
			}
			else{
				oSum += d;
			}
			num /= 10;
		}
		System.out.println("Sum of Even digits : " + eSum );
		System.out.println("Sum of Odd digits : " + oSum );
	
		main(null);
	}
}


