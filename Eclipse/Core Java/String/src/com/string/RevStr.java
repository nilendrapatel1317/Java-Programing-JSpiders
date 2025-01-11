package com.string;

public class RevStr {
	public static void main(String[] args) {
		String s = "abcdcba"
				+ "";
		String s1 = "";
		for (int i = s.length()-1; i >=0; i--) {
			s1+=s.charAt(i);
		}
		
		if(s.equals(s1)) {
			System.out.println("Palindrome String");
		}
		else {
			System.out.println("Not a Palindrome String");			
		}
	}
}
