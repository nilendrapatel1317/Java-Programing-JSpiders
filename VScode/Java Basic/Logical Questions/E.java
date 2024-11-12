// Program to check weather given number is Automorphic or not

import java.util.Scanner;
class E
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter a number : ");
		int num = scn.nextInt();
		int sqr = num*num;
		boolean flag = true;
		
		while(num>0){
			if(num%10 != sqr%10){
				flag = false;
				break;
			}
			
			num /= 10;
			sqr /= 10;
		}
		
		
			
		if(flag) System.out.println("Automorphic Number");
		else System.out.println("Not Automorphic Number");
			
		main(null);
	}
}


