package com.string;


public class Palindrome_String {
	public static void main(String[] args) {
		String s2 = "ana";
		System.out.println(palindrome1(s2));
		System.out.println(palindrome2(s2));
	}
	
	
	public static boolean palindrome1(String s) {
		int startIndex = 0;
		int endIndex = s.length()-1;
		
		while( startIndex < endIndex) {
			if(s.charAt(startIndex) != s.charAt(endIndex)) {
				return false;
			}
			
			startIndex++;
			endIndex--;
		}
		return true;
	}
	public static boolean palindrome2(String s) {
		return new StringBuilder(s).reverse().toString().equals(s);
	}
	
}
