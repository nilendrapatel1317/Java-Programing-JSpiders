package com.mobile_java_project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MobileDriver {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		boolean flag = true;
		Mobile mobile = null;
		
		do {
			System.out.println("===================");
			System.out.println("       MENU        ");
			System.out.println("===================");
			System.out.println("1. Add Mobile \n2. Display Details \n3. Display Price \n4. Change RAM \n5. Change ROM \n6. Change Color \n7. Exit");
			System.out.println();
			System.out.print("Enter Your Option : ");
			
			try {
				
				int option = scn.nextInt();
				switch (option) {
				case 1: {
					System.out.println("----------------------");
					System.out.println("Adding Mobile Details ");
					System.out.println("----------------------");
					System.out.print("Enter Mobile Name : ");
					String name = scn.next();
					System.out.print("Enter Mobile RAM : ");
					int ram = scn.nextInt();
					System.out.print("Enter Mobile ROM : ");
					int rom = scn.nextInt();
					System.out.print("Enter Mobile Price : ");
					double price = scn.nextDouble();
					System.out.print("Enter Mobile Color : ");
					String color = scn.next();
					
					mobile = new Mobile(name, ram, rom, price, color);
					System.out.println("_______________________");
					System.out.println("SUCCESS: Mobile Added !");
				}break;
				
				case 2: {
					if(mobile != null) {
						mobile.display();
					}
					else {
						System.out.println("--------------------------");
						System.out.println("WARRING: No Mobile Added !");
						System.out.println("--------------------------");
					}
				}break;
				
				case 3: {
					if(mobile != null) {
						System.out.println("--------------");
						System.out.println("Mobile Price !" );
						System.out.println("--------------");
						System.out.println("Rs " + mobile.getPrice() + "/-");;
					}
					else {
						System.out.println("--------------------------");
						System.out.println("WARRING: No Mobile Added !");
						System.out.println("--------------------------");
					}
				}break;
				
				case 4: {
					if(mobile != null) {
						System.out.println("------------------");
						System.out.println("Change Mobile RAM ");
						System.out.println("------------------");
						System.out.print("Enter New RAM : ");
						int newRam = scn.nextInt();
						
						mobile.setRam(newRam);
						
						System.out.println("_____________________________");
						System.out.println("SUCCESS: Mobile RAM Changed !");
					}
					else {
						System.out.println("--------------------------");
						System.out.println("WARRING: No Mobile Added !");
						System.out.println("--------------------------");
					}
				}break;
				
				case 5: {
					if(mobile != null) {
						System.out.println("------------------");
						System.out.println("Change Mobile ROM ");
						System.out.println("------------------");
						System.out.print("Enter New ROM : ");
						int newRom = scn.nextInt();
						
						mobile.setRom(newRom);
						
						System.out.println("_____________________________");
						System.out.println("SUCCESS: Mobile ROM Changed !");
					}
					else {
						System.out.println("--------------------------");
						System.out.println("WARRING: No Mobile Added !");
						System.out.println("--------------------------");
					}
				}break;
				
				case 6: {
					if(mobile != null) {
						System.out.println("------------------");
						System.out.println("Change Mobile Color ");
						System.out.println("------------------");
						System.out.print("Enter New Color : ");
						String newColor = scn.next();
						
						mobile.setColor(newColor);
						
						System.out.println("_____________________________");
						System.out.println("SUCCESS: Mobile Color Changed !");
					}
					else {
						System.out.println("--------------------------");
						System.out.println("WARRING: No Mobile Added !");
						System.out.println("--------------------------");
					}
				}break;
				
				case 7: {
					System.out.println("--------------------------------------");
					System.out.println("  Do you want to exit program ? \n(Enter 'Y' for 'Yes' OR 'N' for 'No')");
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
