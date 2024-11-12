package com.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Password {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter your password : ");
		String pwd = scn.next();
		
		if(isPassword(pwd)) {
			System.out.println("Valid Password");
		}
		else {
			System.out.println("Not Valid Password");
		}
		
		
		
		main(null);
	}
	
	public static boolean isPassword(String pwd) {
		String exp = "(?=.*[!@#$])(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,15}"; 
		Pattern p = Pattern.compile(exp);
		
		
		return p.matcher(pwd).matches();
	}
}
