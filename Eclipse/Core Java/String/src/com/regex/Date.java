package com.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Date {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter your Date : ");
		String d = scn.next();
		
		
		if(isDate(d)) {
			System.out.println("Valid Date");
		}
		else {
			System.out.println("Not Valid Date");
		}
		
		
		
		main(null);
	}
	
	public static boolean isDate(String d) {
		String exp = "(?=.*0[1-9)(?=.*[12][0-9])(?=.*3[01]).{2}"; 
		Pattern p = Pattern.compile(exp);
		
		
		return p.matcher(d).matches();
	}
}
