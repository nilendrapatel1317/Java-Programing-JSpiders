package com.string;

import java.util.Scanner;

public class Remove_Spaces {
	public static void main(String[] arg) {
		String s = "Java is easy";
		System.out.println(s);
		System.out.println(reversestr(s)); // called method
		System.out.println(reverseString(s)); // called method
	}

	// reverse string method
	public static String reversestr(String s) {
		String r = "";
		for (int i = s.length(); i > 0; i--) // execute until condition i>0 becomes false
		{
			r += s.charAt(i - 1);
		}
		return r;
	}

	public static String reverseString(String s) {
		if (s.trim().length() <= 0) // checks the string if empty
			return s;
		return reverseString(s.substring(1)) + s.charAt(0); // recursively called function
	}

}
