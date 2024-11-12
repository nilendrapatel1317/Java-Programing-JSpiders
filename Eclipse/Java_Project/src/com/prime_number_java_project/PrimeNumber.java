package com.prime_number_java_project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumber {
	
	public static boolean isPrime(int n) {
		if(n <= 0) return false;
		
		if(n == 1) return true;
		
		for (int i = 2; i <= n/2; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean flag = true;
		
		do {
			System.out.println("============================");
			System.out.println("   PRIME NUMBER OPERATION   ");
			System.out.println("============================");
			System.out.println("1. Given Num is Prime or Not. \n2. Prime Num up to end range. \n3. Prime Num btw start and End range. \n4. 1st Prime Num btw start and end range. \n5. 2nd Prime Num btw start and end range. \n6. 1st Highest Prime Num btw start and end range. \n7. 2nd Highest Prime Num btw start and end range. \n8. Alternate Prime Num btw given start and end range. \n9. Exit");
			System.out.println("------------------");
			System.out.print("Enter Your Option : ");
			
			try {
				
				int option = scn.nextInt();
				switch (option) {
				case 1: {
					//Given Number is Prime or Not
					System.out.println();
					System.out.print("Eneter a number : ");
					int n=scn.nextInt();		
					
					if(isPrime(n)) {
						System.out.println(n + " is a prime number");
					}
					else {
						System.out.println(n + " is not a prime number");
						
					}
				}break;
				
				case 2: {
					//Prime Number up to end range
					System.out.println();
					System.out.print("Eneter a range : ");
					int range = scn.nextInt();
					System.out.println("Prime Number up to range : " + range );
					for (int i = 1; i <= range; i++) {
						if(isPrime(i)) {
							System.out.println(i);
						}
					}
				}break;
				
				case 3: {
					//Prime Number between start and End range
					System.out.println();
					System.out.print("Enter starting range : ");
					int start = scn.nextInt(); 
					System.out.print("Enter ending range : ");
					int end = scn.nextInt();
					System.out.println("Prime Number btw " + start + " and " + end + " range" );
					
					for (int i = start; i <= end; i++) {
						if(isPrime(i)) {
							System.out.println(i);
						}
					}
				}break;
				
				case 4: {
					//First Prime Number between start and end range
					System.out.println();
					System.out.print("Enter starting range : ");
					int start = scn.nextInt(); 
					System.out.print("Enter ending range : ");
					int end = scn.nextInt();
					System.out.print("1st Prime Number btw " + start + " and " + end + " range : " );
					int count = 1;
					for (int i = start; i <= end; i++) {
						if(isPrime(i)) {
							if(count == 1) {
								System.out.println(i);
								break;
							}
							count++;
						}
					}
				}break;
				
				case 5: {
					//Second Prime Number between start and end range
					System.out.println();
					System.out.print("Enter starting range : ");
					int start = scn.nextInt(); 
					System.out.print("Enter ending range : ");
					int end = scn.nextInt();
					System.out.print("2nd Prime Number btw " + start + " and " + end + " range : " );
					int count = 1;
					for (int i = start; i <= end; i++) {
						if(isPrime(i)) {
							if(count == 2) {
								System.out.println(i);
								break;
							}
							count++;
						}
					}
				}break;
				
				case 6: {
					//First Highest Prime number between given start and end range
					System.out.println();
					System.out.print("Enter starting range : ");
					int start = scn.nextInt(); 
					System.out.print("Enter ending range : ");
					int end = scn.nextInt();
					System.out.print("1st Highest Prime Number btw " + start + " and " + end + " range : " );
					int count = 1;
					for (int i = end; i >= start; i--) {
						if(isPrime(i)) {
							if(count == 1) {
								System.out.println(i);
								break;
							}
							count++;
						}
					}
				}break;
				
				case 7:{
					//Second Highest Prime number between given start and end range
					System.out.println();
					System.out.print("Enter starting range : ");
					int start = scn.nextInt(); 
					System.out.print("Enter ending range : ");
					int end = scn.nextInt();
					System.out.print("2nd Highest Prime Number btw " + start + " and " + end + " range : " );
					int count = 1;
					for (int i = end; i >= start; i--) {
						if(isPrime(i)) {
							if(count == 2) {
								System.out.println(i);
								break;
							}
							count++;
						}
					}
				}
				
				case 8:{
					//Alternate Prime Number between given start and end range
					System.out.println();
					System.out.print("Enter starting range : ");
					int start = scn.nextInt(); 
					System.out.print("Enter ending range : ");
					int end = scn.nextInt();
					
					System.out.println("Alternate Prime Number btw " + start + " and " + end + " range : " );
					int count = 1;
					for (int i = start; i <= end; i++) {
						if(isPrime(i)) {
							if(count%2 != 0) {
								System.out.println(i);
							}
							count++;
						}
					}
				}
				
				case 9: {
					System.out.println();
					System.out.println("--------------------------------------");
					System.out.println("  Do you want to exit program ? \n\n(Enter 'Y' for 'Yes' OR 'N' for 'No')");
					System.out.println("--------------------------------------");
					char opt = scn.next().charAt(0);
					if (opt == 'Y' || opt == 'y') {
						System.out.println("------------------------------------");
						System.out.println("PROGRAM EXIT: Thanks ! Visit Again !");
						System.out.println("------------------------------------");
						flag = false;
					}
					else {
						System.out.println("------------------------------------");
						System.out.println("PROGRAM CONTINUE");
						System.out.println("------------------------------------");
						flag = true;
					}
					
				}break;
				
				default:
					System.out.println("Invalid");
				}
				
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("ERROR: Invalid Input Data Type ! Please Enter Valid Data Type.");
				scn.nextLine();
			}
			System.out.println();
			
		} while (flag);
		
	}

}