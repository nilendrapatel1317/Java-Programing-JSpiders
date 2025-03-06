package com.number_program_in_java;
import java.util.Scanner;

public class NumberProgram {
	
	//For Strong Number
	public static int strongNum(int n) {
		if(n==0) return 0;
		
		return factorial(n%10) + strongNum(n/10);
	}
	
	//For Factorial Number
	public static int factorial(int n) {
		if(n == 0 || n == 1) return 1;
		return n* factorial(n-1);
	}

	//For Perfect Number
	public static int perfectNum(int n , int i) {
		if (i == 0) return 0;
		if(n==1) return 1;
		
		if(n%i == 0) return i + perfectNum(n, i-1);
				
		return perfectNum(n, i-1);
	}
	
	//For Armstrong Number
	public static int armStrongNum(int n, int count) {
		if(n == 0) return 0;
		
		return (int) Math.pow(n%10, count) + armStrongNum(n/10, count);
		
	}
	
	//For Count Digit in number
	public static int countDigit(int n) {
		if(n==0) return 1;
		int count = 0;
		while(n>0) {
			count++;
			n/=10;
		}
		return count;
	}
	

	//Main() method
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean flag = true;
		do {
			System.out.println("====================================================");
			System.out.println("Number Programs in Java");
			System.out.println("====================================================");
			System.out.println();
			System.out.println("1. Strong Number \n2. Perfect Number \n3. Armstrong Number \n4. Exit ");
			System.out.println();
			System.out.print("Enter your option : "); 
			int option = scn.nextInt();
			switch (option) {
			case 1: {
				
				System.out.println();
				System.out.println("Operation : Strong Number");
				System.out.print("Enter number : ");
				int num = scn.nextInt();
				System.out.println();
				System.out.println("----------------------------------------------------");
				if(num == strongNum(num)) {
					System.out.println("NUMBER :" + num + " IS A STRONG NUMBER");
				}
				else {
					System.out.println("NUMBER :" + num + " IS NOT A STRONG NUMBER");
				}
				System.out.println("----------------------------------------------------");
				
				
			}break;
			case 2: {
				System.out.println();
				System.out.println("Operation : Perfect Number");
				System.out.print("Enter number : ");
				int num = scn.nextInt();
				System.out.println();
				System.out.println("----------------------------------------------------");
				if(num == perfectNum(num, num/2)) {
					System.out.println("NUMBER :" + num + " IS A PERFECT NUMBER");
				}
				else {
					System.out.println("NUMBER :" + num + " IS NOT A PERFECT NUMBER");
				}
				System.out.println("----------------------------------------------------");
								
			}break;
			case 3: {
				System.out.println();
				System.out.println("Operation : Armstrong Number");
				System.out.print("Enter number : ");
				int num = scn.nextInt();
				System.out.println();
				System.out.println("----------------------------------------------------");
				if(num == armStrongNum(num, countDigit(num))) {
					System.out.println("NUMBER :" + num + " IS A ARMSTRONG NUMBER");
				}
				else {
					System.out.println("NUMBER :" + num + " IS NOT A ARMSTRONG NUMBER");
				}
				System.out.println("----------------------------------------------------");
				
				
			}break;
			case 4:{
				flag = false;
				System.out.println("Program Exit !");
			}
			default:
				flag=false;
				System.out.println("Invalid Option");
			}
			
		} while (flag);
	}
	
}