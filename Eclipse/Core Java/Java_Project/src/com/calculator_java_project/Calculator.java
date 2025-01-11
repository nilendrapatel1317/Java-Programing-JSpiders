package com.calculator_java_project;
import java.util.Scanner;


public class Calculator {
	
	public static void performOperation(String operation) {
		Scanner scn = new Scanner(System.in);
		System.out.println();
		System.out.println(operation + " Operations ");
		System.out.println("=======================");
		System.out.print("Enter 1st operand : ");
		int a = scn.nextInt();
		System.out.print("Enter 2nd operand : ");
		int b = (int) scn.nextInt();
		
		switch (operation) {
			case "Adition": 
				System.out.println("RESULT : " + (a+b));
				break;
			
			case "Subtraction": 
				System.out.println("RESULT : " + (a-b));
				break;
			
			case "Multiplication": 
				System.out.println("RESULT : " + (a*b));
				break;
			
			case "Division": 
				if (b != 0) {
		            System.out.println("RESULT : " + ((double)a/b));
		        } else {
		            System.out.println("Error: Division by zero is undefined.");
		        }
				break;
			
		}
//		main(null);
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		boolean flag = true;
		do {
			System.out.println();
			System.out.println("Simple Calculator");
			System.out.println("=======================");
			System.out.println("Press 1 for Adition");
			System.out.println("Press 2 for Substraction");
			System.out.println("Press 3 for Multiplication");
			System.out.println("Press 4 for Division");
			System.out.println("Press 5 for Exit ");
			
			Scanner scn = new Scanner(System.in);
			System.out.print("Enter your option : ");
			int option = scn.nextInt();
			
			switch (option) {
			case 1: {
				performOperation("Adition");
				break;
			}
			case 2: {
				performOperation("Subtraction");
				break;
			}
			case 3: {
				performOperation("Multiplication");
				break;
			}
			case 4: {
				performOperation("Division");
				break;
			}
			case 5: {
				System.out.println();
				System.out.println("Exiting the program.");
				break;
			}
			
			default:
				System.out.println();
				System.out.println("Invalid option. Please select a valid operation.");
			}
		} while (flag);
	}
}
